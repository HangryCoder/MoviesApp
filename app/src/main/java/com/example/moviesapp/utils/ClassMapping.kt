package com.example.moviesapp.utils

import com.example.moviesapp.database.entities.Movie
import com.example.moviesapp.model.MovieResults

fun MovieResults.toMovieEntity(): List<Movie>? {
    val movieResults = this.results
    return movieResults?.map {
        Movie(id = it.id, title = it.title, poster = it.poster, rating = it.rating.toString())
    }
}