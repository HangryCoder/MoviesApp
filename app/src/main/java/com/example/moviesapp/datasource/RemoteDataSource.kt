package com.example.moviesapp.datasource

import com.example.moviesapp.BuildConfig
import com.example.moviesapp.networking.MoviesApi
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val movieApi: MoviesApi) {
    suspend fun getPopularMovies() = movieApi.getPopularMovies(BuildConfig.API_KEY)
}