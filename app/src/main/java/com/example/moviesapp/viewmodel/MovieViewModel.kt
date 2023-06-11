package com.example.moviesapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesapp.database.entities.Movie
import com.example.moviesapp.database.entities.Playlist
import com.example.moviesapp.repository.MovieRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class MovieViewModel @Inject constructor(private val repository: MovieRepository) : ViewModel() {

    private var _movies = MutableLiveData<List<Movie>>()
    val movies: LiveData<List<Movie>> by lazy { _movies }

    private var _playlists = MutableLiveData<List<Playlist>>()
    val playlists: LiveData<List<Playlist>> by lazy { _playlists }

    private var selectedMovieId: Int? = null

    fun getPopularMovies() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = repository.getPopularMovies()
            response?.let {
                _movies.postValue(it)
            }
        }
    }

    fun setMovieId(id: Int) {
        selectedMovieId = id
    }

    fun addPlayList(name: String) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addPlaylist(Playlist(name = name))
            getPlaylists()
        }
    }

    fun addMovieToPlaylist(playlistId: Int?) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addMovieToPlaylist(movieId = selectedMovieId, playlistId = playlistId)
        }
    }

    fun getPlaylists() {
        viewModelScope.launch(Dispatchers.IO) {
            val allPlaylists = repository.getPlaylists()
            _playlists.postValue(allPlaylists)
        }
    }
}