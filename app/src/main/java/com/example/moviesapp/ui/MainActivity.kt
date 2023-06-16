package com.example.moviesapp.ui

import android.os.Bundle
import com.example.moviesapp.databinding.ActivityMainBinding
import com.example.moviesapp.ui.adapter.MovieAdapter
import com.example.moviesapp.viewmodel.MovieViewModel
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var adapter: MovieAdapter

    @Inject
    lateinit var viewModel: MovieViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initialSetup()
    }

    private fun initialSetup() {
        setupRecyclerView()
        fetchPopularMovies()
    }

    private fun fetchPopularMovies() {
        viewModel.getPopularMoviesWithPlaylists()

        viewModel.moviesWithPlaylists.observe(this) { moviesWithPlaylists ->
            adapter.moviesWithPlaylists = moviesWithPlaylists
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