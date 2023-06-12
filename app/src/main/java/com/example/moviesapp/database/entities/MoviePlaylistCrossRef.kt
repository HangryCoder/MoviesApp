package com.example.moviesapp.database.entities

import androidx.room.Entity

@Entity(primaryKeys = ["movieId", "playlistId"])
data class MoviePlaylistCrossRef(
    val movieId: Int, val playlistId: Int
)