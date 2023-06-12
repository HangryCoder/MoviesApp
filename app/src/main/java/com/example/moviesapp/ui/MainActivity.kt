package com.example.moviesapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.moviesapp.MyApplication
import com.example.moviesapp.database.MovieWithPlaylists
import com.example.moviesapp.database.entities.Movie
import com.example.moviesapp.databinding.ActivityMainBinding
import com.example.moviesapp.di.ActivityComponent
import com.example.moviesapp.ui.adapter.MovieAdapter
import com.example.moviesapp.viewmodel.MovieViewModel
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var adapter: MovieAdapter

    @Inject
    lateinit var viewModel: MovieViewModel

    lateinit var activityComponent: ActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        setupDagger()
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initialSetup()
    }

    private fun setupDagger() {
        activityComponent = (application as MyApplication).appComponent.activityComponent().create()
        activityComponent.inject(this)
    }

    private fun initialSetup() {
        setupRecyclerView()
        fetchPopularMovies()
    }

    private fun fetchPopularMovies() {
        viewModel.getPopularMoviesWithPlaylists()

        viewModel.moviesWithPlaylists.observe(this) { moviesWithPlaylists ->
            adapter.moviesWithPlaylists = moviesWithPlaylists// as ArrayList<MovieWithPlaylists>?
        }
    }

    private fun setupRecyclerView() {
        adapter.buttonClick = {
            viewModel.setMovieId(it)
            PlaylistBottomSheet().apply {
                show(supportFragmentManager, PlaylistBottomSheet.TAG)
            }
        }
        binding.movieRecyclerView.adapter = adapter
    }
}