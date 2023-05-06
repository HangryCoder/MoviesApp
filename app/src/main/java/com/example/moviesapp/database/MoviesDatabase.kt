package com.example.moviesapp.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.moviesapp.database.dao.MovieDao
import com.example.moviesapp.database.entities.Movie

@Database(entities = [Movie::class], version = 1)
abstract class MovieDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
}