/*
package com.example.moviesapp.di

import android.content.Context
import androidx.room.Room
import com.example.moviesapp.database.MovieDatabase
import com.example.moviesapp.datasource.LocalDataSource
import com.example.moviesapp.datasource.RemoteDataSource
import com.example.moviesapp.networking.MoviesApi
import com.example.moviesapp.repository.MovieRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(val context: Context) {

    @Provides
    fun provideContext() = context

    */
/*  @Singleton
      @Provides
      fun provideDatabase(context: Context): MovieDatabase {
          return Room.databaseBuilder(
              context, MovieDatabase::class.java, "movie-database"
          ).build()
}*//*


    @Provides
    fun provideLocalDataSource(context: Context*/
/*database: MovieDatabase*//*
): LocalDataSource {
        return LocalDataSource(
            context
        )
    }

    @Provides
    fun provideRemoteDataSource(moviesApi: MoviesApi): RemoteDataSource {
        return RemoteDataSource(moviesApi)
    }

    @Provides
    fun provideRepository(
        localDataSource: LocalDataSource, remoteDataSource: RemoteDataSource
    ): MovieRepository {
        return MovieRepository(localDataSource, remoteDataSource)
    }
}*/
