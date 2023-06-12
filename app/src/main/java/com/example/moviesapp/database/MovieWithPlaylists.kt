package com.example.moviesapp.database

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.example.moviesapp.database.entities.Movie
import com.example.moviesapp.database.entities.MoviePlaylistCrossRef
import com.example.moviesapp.database.entities.Playlist

data class MovieWithPlaylists(
    @Embedded val movie: Movie,
    @Relation(
        parentColumn = "movieId",
        entityColumn = "playlistId",
        associateBy = Junction(MoviePlaylistCrossRef::class)
    )
    val playlists: List<Playlist>
)