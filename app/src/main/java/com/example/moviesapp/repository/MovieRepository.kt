package com.example.moviesapp.repository

import com.example.moviesapp.networking.MoviesApi
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieRepository @Inject constructor(private val movieApi: MoviesApi) {
    suspend fun getPopularMovies(apiKey: String) = movieApi.getPopularMovies(apiKey)
}