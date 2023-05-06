package com.example.moviesapp.model

import com.squareup.moshi.Json

data class MovieResults(val page: Int, val results: List<Movie>?)

data class Movie(
    val id: Int?,
    @Json(name = "original_title") val title: String?,
    @Json(name = "poster_path") val poster: String?,
    @Json(name = "vote_average") val rating: Float?,
)