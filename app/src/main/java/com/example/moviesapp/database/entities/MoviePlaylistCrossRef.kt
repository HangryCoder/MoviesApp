package com.example.moviesapp.database.entities

import androidx.room.Entity

@Entity(primaryKeys = ["playlistId", "movieId"])
data class MoviePlaylistCrossRef(
    val playlistId: Int,
    val movieId: Int
)