package com.example.moviesapp.datasource

import com.example.moviesapp.database.entities.Movie
import com.example.moviesapp.database.MovieDatabase
import com.example.moviesapp.database.MovieWithPlaylists
import com.example.moviesapp.database.entities.MoviePlaylistCrossRef
import com.example.moviesapp.database.entities.Playlist
import javax.inject.Inject

class LocalDataSource @Inject constructor(private val database: MovieDatabase) {

    suspend fun getPopularMoviesFromDB(): List<Movie> {
        return database.movieDao().getAll()
    }

    suspend fun insertMovies(movies: List<Movie>) {
        database.movieDao().insertAll(movies)
    }

    suspend fun addPlaylist(playlist: Playlist) {
        database.playlistDao().addPlaylist(playlist)
    }

    suspend fun getPlaylists(): List<Playlist> {
        return database.playlistDao().getPlaylists()
    }

    suspend fun getMovieWithPlaylists(): List<MovieWithPlaylists> {
        return database.moviePlaylistDao().getMovieWithPlaylists()
    }

    suspend fun addMovieToPlaylist(moviePlaylistCrossRef: MoviePlaylistCrossRef) {
        database.moviePlaylistDao().addMoviePlaylistCrossRef(moviePlaylistCrossRef)
    }
}