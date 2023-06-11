package com.example.moviesapp.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Playlist(@PrimaryKey val id: Int?, val name: String?)