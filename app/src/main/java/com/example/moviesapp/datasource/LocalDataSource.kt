package com.example.moviesapp.datasource

import com.example.moviesapp.database.entities.Movie
import com.example.moviesapp.database.MovieDatabase
import javax.inject.Inject

class LocalDataSource @Inject constructor(private val database: MovieDatabase) {

    suspend fun getPopularMoviesFromDB(): List<Movie> {
        return database.movieDao().getAll()
    }

    suspend fun insertMovies(movies: List<Movie>) {
        database.movieDao().insertAll(movies)
    }
}