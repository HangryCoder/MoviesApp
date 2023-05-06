package com.example.moviesapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesapp.model.Movie
import com.example.moviesapp.repository.MovieRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class MovieViewModel @Inject constructor(private val repository: MovieRepository) : ViewModel() {

    private val apiKey = "38a73d59546aa378980a88b645f487fc"
    private var _movies = MutableLiveData<List<Movie>>()
    val movies: LiveData<List<Movie>> by lazy { _movies }

    fun getPopularMovies() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = repository.getPopularMovies(apiKey)
                response.results?.let {
                    _movies.postValue(it)
                }
            }catch (e: Exception){
                e.printStackTrace()
            }

        }
    }
}