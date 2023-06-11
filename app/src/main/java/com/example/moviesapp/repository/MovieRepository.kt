package com.example.moviesapp.repository

import com.example.moviesapp.database.entities.Movie
import com.example.moviesapp.database.entities.MoviePlaylistCrossRef
import com.example.moviesapp.database.entities.Playlist
import com.example.moviesapp.datasource.LocalDataSource
import com.example.moviesapp.datasource.RemoteDataSource
import com.example.moviesapp.utils.toMovieEntity
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieRepository @Inject constructor(
    private val localDataSource: LocalDataSource, private val remoteDataSource: RemoteDataSource
) {
    suspend fun getPopularMovies(): List<Movie>? {
        var movies: List<Movie>? = localDataSource.getPopularMoviesFromDB()
        if (movies.isNullOrEmpty()) {
            try {
                val response = remoteDataSource.getPopularMovies()
                movies = response.toMovieEntity()
                movies?.let {
                    localDataSource.insertMovies(it)
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

        return movies
    }

    suspend fun addPlaylist(playlist: Playlist) {
        localDataSource.addPlaylist(playlist)
    }

    suspend fun addMovieToPlaylist(movieId: Int?, playlistId: Int?) {
        localDataSource.insertMovieIntoPlaylist(
            MoviePlaylistCrossRef(
                movieId = movieId, playlistId = playlistId
            )
        )
    }

    suspend fun getPlaylists(): List<Playlist> {
        return localDataSource.getPlaylists()
    }
}