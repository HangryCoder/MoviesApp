package com.example.moviesapp.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Movie(
    @PrimaryKey val id: Int,
    val title: String?,
    val poster: String?,
    val rating: String?,
    val playlistIds: List<Int>? = null
)