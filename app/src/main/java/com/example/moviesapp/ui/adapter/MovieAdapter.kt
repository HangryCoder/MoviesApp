package com.example.moviesapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.moviesapp.database.MovieWithPlaylists
import com.example.moviesapp.databinding.ItemMovieBinding

const val MOVIE_BASE_URL = "https://image.tmdb.org/t/p/w500"

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {
    var moviesWithPlaylists: List<MovieWithPlaylists>? = null
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    var buttonClick: ((Int) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val binding = ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(binding)
    }

    override fun getItemCount(): Int = moviesWithPlaylists?.size ?: 0

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = moviesWithPlaylists?.get(position)
        movie?.let {
            holder.bind(it)
        }
    }

    inner class MovieViewHolder(binding: ItemMovieBinding) : ViewHolder(binding.root) {

        private val movieTitleTextView = binding.movieTitle
        private val movieRatingTextView = binding.movieRating
        private val moviePlaylistTextView = binding.moviePlaylist
        private val moviePosterImageView = binding.moviePoster
        private val starButton = binding.movieStarButton

        fun bind(movieWithPlaylists: MovieWithPlaylists) {
            Glide.with(moviePosterImageView.context)
                .load(MOVIE_BASE_URL + movieWithPlaylists.movie.poster).into(moviePosterImageView)

            movieTitleTextView.text = movieWithPlaylists.movie.title
            movieRatingTextView.text = "Rating: ${movieWithPlaylists.movie.rating}"
            starButton.setOnClickListener {
                movieWithPlaylists.movie.movieId?.let { id ->
                    buttonClick?.invoke(id)
                }
            }

            moviePlaylistTextView.text = movieWithPlaylists.playlists.joinToString {
                it.name.toString()
            }
        }
    }
}