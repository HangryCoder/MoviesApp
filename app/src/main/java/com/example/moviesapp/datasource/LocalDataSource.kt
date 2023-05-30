package com.example.moviesapp.datasource

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.moviesapp.database.entities.Movie
import com.example.moviesapp.database.MovieDatabase
import javax.inject.Inject

/*class LocalDataSource @Inject constructor(val database: MovieDatabase) {
    */

class LocalDataSource @Inject constructor(context: Context) {

   private val database: MovieDatabase =  Room.databaseBuilder(
        context, MovieDatabase::class.java, "movie-database"
    ).build()

    suspend fun getPopularMoviesFromDB(): List<Movie> {
        return database.movieDao().getAll()
    }

    suspend fun insertMovies(movies: List<Movie>) {
        database.movieDao().insertAll(movies)
    }
}