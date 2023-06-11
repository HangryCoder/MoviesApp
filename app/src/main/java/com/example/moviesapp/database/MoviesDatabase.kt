package com.example.moviesapp.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.moviesapp.database.dao.MovieDao
import com.example.moviesapp.database.dao.MovieWithPlaylistDao
import com.example.moviesapp.database.dao.PlaylistDao
import com.example.moviesapp.database.entities.Movie
import com.example.moviesapp.database.entities.Playlist

@Database(entities = [Movie::class, Playlist::class, MovieWithPlaylists::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class MovieDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao

    abstract fun playlistDao() : PlaylistDao
    abstract fun movieWithPlaylistDao() : MovieWithPlaylistDao
}