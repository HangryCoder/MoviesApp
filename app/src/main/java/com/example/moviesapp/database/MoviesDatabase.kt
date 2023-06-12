package com.example.moviesapp.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.moviesapp.database.dao.MovieDao
import com.example.moviesapp.database.dao.MoviePlaylistDao
import com.example.moviesapp.database.dao.PlaylistDao
import com.example.moviesapp.database.entities.Movie
import com.example.moviesapp.database.entities.MoviePlaylistCrossRef
import com.example.moviesapp.database.entities.Playlist

@Database(
    entities = [Movie::class, Playlist::class, MoviePlaylistCrossRef::class],
    version = 1,
    exportSchema = false
)
abstract class MovieDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao

    abstract fun playlistDao(): PlaylistDao

    abstract fun moviePlaylistDao(): MoviePlaylistDao
}