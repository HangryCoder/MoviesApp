package com.example.moviesapp.di

import com.example.moviesapp.database.MovieDatabase
import com.example.moviesapp.datasource.LocalDataSource
import com.example.moviesapp.datasource.RemoteDataSource
import com.example.moviesapp.networking.MoviesApi
import com.example.moviesapp.repository.MovieRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [NetworkModule::class, DatabaseModule::class])
class ApplicationModule {

    @Provides
    fun provideRemoteDataSource(moviesApi: MoviesApi): RemoteDataSource {
        return RemoteDataSource(moviesApi)
    }

    @Provides
    fun provideLocalDataSource(database: MovieDatabase): LocalDataSource {
        return LocalDataSource(database)
    }

    @Singleton
    @Provides
    fun provideMovieRepository(
        localDataSource: LocalDataSource, remoteDataSource: RemoteDataSource
    ): MovieRepository {
        return MovieRepository(localDataSource, remoteDataSource)
    }
}