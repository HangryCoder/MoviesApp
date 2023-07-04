package com.example.moviesapp.repository

import com.example.moviesapp.database.MovieWithPlaylists
import com.example.moviesapp.database.entities.MoviePlaylistCrossRef
import com.example.moviesapp.database.entities.Playlist
import com.example.moviesapp.datasource.LocalDataSource
import com.example.moviesapp.datasource.RemoteDataSource
import com.example.moviesapp.networking.NetworkResponse
import com.example.moviesapp.utils.toMovieEntity
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieRepository @Inject constructor(
    private val localDataSource: LocalDataSource, private val remoteDataSource: RemoteDataSource
) {

    suspend fun getPopularMoviesWithPlaylists(): List<MovieWithPlaylists>? {
        var movieWithPlaylists: List<MovieWithPlaylists>? = localDataSource.getMovieWithPlaylists()
        if (movieWithPlaylists.isNullOrEmpty()) {

            when (val response = remoteDataSource.getPopularMovies()) {
                is NetworkResponse.Success -> {
                    response.body.toMovieEntity()?.let {
                        localDataSource.insertMovies(it)
                    }
                    movieWithPlaylists = localDataSource.getMovieWithPlaylists()
                }
                else -> {
                    //Error Case
                }
            }

            /*try {
                val response = remoteDataSource.getPopularMovies()
                response.toMovieEntity()?.let {
                    localDataSource.insertMovies(it)
                }
                movieWithPlaylists = localDataSource.getMovieWithPlaylists()
            } catch (e: Exception) {
                e.printStackTrace()
            }*/
        }

        return movieWithPlaylists
    }

    suspend fun addPlaylist(playlist: Playlist) {
        localDataSource.addPlaylist(playlist)
    }

    suspend fun getPlaylists(): List<Playlist> {
        return localDataSource.getPlaylists()
    }

    suspend fun addMovieToPlaylist(movieId: Int, playlistId: Int) {
        localDataSource.addMovieToPlaylist(MoviePlaylistCrossRef(movieId, playlistId))
    }
}