package com.example.moviesapp.datasource

import com.example.moviesapp.database.entities.Movie
import com.example.moviesapp.database.MovieDatabase
import javax.inject.Inject

class LocalDataSource @Inject constructor(private val database: MovieDatabase) {

    fun getPopularMoviesFromDB(): List<Movie> {
        return database.movieDao().getAll()
    }

    fun insertMovies(movies: List<Movie>) {
        database.movieDao().insertAll(movies)
    }
}