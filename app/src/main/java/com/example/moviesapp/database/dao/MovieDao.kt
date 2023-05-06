package com.example.moviesapp.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.moviesapp.database.entities.Movie

@Dao
interface MovieDao {
    @Query("SELECT * FROM movie")
    fun getAll(): List<Movie>

    @Insert
    fun insertAll(movies: List<Movie>)

   //Update movie with playlists!
}