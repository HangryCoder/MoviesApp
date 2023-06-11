package com.example.moviesapp.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.moviesapp.database.entities.Playlist

@Dao
interface PlaylistDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addPlaylist(playlist: Playlist)

    @Query("SELECT * FROM Playlist")
    suspend fun getPlaylists(): List<Playlist>
}