package com.example.moviesapp.database.entities

import androidx.room.Entity

@Entity(primaryKeys = ["playlistId", "movieId"])
data class MoviePlaylistCrossRef(
    val playlistId: Long,
    val movieId: Long
)