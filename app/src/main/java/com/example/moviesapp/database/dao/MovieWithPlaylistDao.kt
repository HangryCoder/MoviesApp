package com.example.moviesapp.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.example.moviesapp.database.MovieWithPlaylists
import com.example.moviesapp.database.entities.MoviePlaylistCrossRef

@Dao
interface MovieWithPlaylistDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMoviePlaylistCrossRef(moviePlaylistCrossRef: MoviePlaylistCrossRef)

    @Transaction
    @Query("SELECT * FROM Movie")
    suspend fun getMoviesWithPlaylists(): List<MovieWithPlaylists>
}