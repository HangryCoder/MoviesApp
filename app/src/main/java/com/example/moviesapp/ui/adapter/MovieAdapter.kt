package com.example.moviesapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.moviesapp.database.entities.Movie
import com.example.moviesapp.databinding.ItemMovieBinding

const val MOVIE_BASE_URL = "https://image.tmdb.org/t/p/w500"

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {
    var movies: ArrayList<Movie>? = null
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    var buttonClick: (() -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val binding = ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(binding)
    }

    override fun getItemCount(): Int = movies?.size ?: 0

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movies?.get(position)
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

        //eg: https://image.tmdb.org/t/p/w500/p60VSQL7usdxztIGokJPpHmKWdU.jpg

        fun bind(movie: Movie) {
            Glide.with(moviePosterImageView.context).load(MOVIE_BASE_URL + movie.poster)
                //.placeholder()
                .into(moviePosterImageView)

            movieTitleTextView.text = movie.title
            movieRatingTextView.text = "Rating: ${movie.rating}"
            starButton.setOnClickListener {
                buttonClick?.invoke()
            }

            //moviePlaylistTextView.text = "Playlist 1"
        }
    }
}