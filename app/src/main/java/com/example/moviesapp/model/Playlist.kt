package com.example.moviesapp.model

data class Playlist(val id: Int, val playlistName: String?, val movieIds: List<Int>? = null)