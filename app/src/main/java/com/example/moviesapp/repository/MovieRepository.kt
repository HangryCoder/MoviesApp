package com.example.moviesapp.repository

import com.example.moviesapp.BuildConfig
import com.example.moviesapp.database.entities.Movie
import com.example.moviesapp.datasource.LocalDataSource
import com.example.moviesapp.datasource.RemoteDataSource
import com.example.moviesapp.networking.MoviesApi
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieRepository @Inject constructor(
    private val localDataSource: LocalDataSource, private val remoteDataSource: RemoteDataSource
) {

    /* suspend fun getPopularMovies(apiKey: String) = remoteDataSource.getPopularMovies(apiKey)
    */

    /*suspend fun getPopularMovies() {
        val movies = localDataSource.getPopularMoviesFromDB()
        if (movies == null) {

        } else {

        }
    }*/

   /* suspend fun getPopularMovies() =
        remoteDataSource.getPopularMovies()*/

    suspend fun getPopularMovies(): List<Movie>  {
        val movies = localDataSource.getPopularMoviesFromDB()
        if (movies == null) {

        } else {

        }

        return movies
    }
}