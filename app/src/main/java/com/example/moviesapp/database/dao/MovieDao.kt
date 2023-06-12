package com.example.moviesapp.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.moviesapp.database.entities.Movie

@Dao
interface MovieDao {
    @Query("SELECT * FROM Movie")
    suspend fun getAll(): List<Movie>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(movies: List<Movie>)

  /*  @Query("SELECT playlistIds FROM Movie WHERE movieId=:id")
    suspend fun getMoviePlaylistIds(id: Int): List<Int>*/

    @Query("SELECT * FROM Movie WHERE movieId=:id")
    suspend fun getMovie(id: Int): Movie

    @Query("UPDATE Movie SET playlistIds=:playlistIds WHERE movieId=:movieId")
    suspend fun updatePlaylistIds(playlistIds: List<Int>, movieId: Int)
}