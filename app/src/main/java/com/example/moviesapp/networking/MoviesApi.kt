package com.example.moviesapp.networking

import com.example.moviesapp.model.MovieResults
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesApi {
    //https://api.themoviedb.org/3/movie/popular?api_key=38a73d59546aa378980a88b645f487fc

    @GET("3/movie/popular")
    suspend fun getPopularMovies(
        @Query("api_key") apiKey: String
    ): MovieResults
}