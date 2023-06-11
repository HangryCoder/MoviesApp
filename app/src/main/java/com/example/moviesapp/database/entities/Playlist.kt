package com.example.moviesapp.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Playlist(@PrimaryKey(autoGenerate = true) val id: Int? = null, val name: String?)