package com.example.moviesapp.di

import android.content.Context
import androidx.room.Room
import com.example.moviesapp.database.MovieDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule(val applicationContext: Context) {

    @Singleton
    @Provides
    fun provideApplicationContext(): Context {
        return applicationContext
    }

    @Singleton
    @Provides
    fun provideDatabase(context: Context): MovieDatabase {
        return Room.databaseBuilder(
            context, MovieDatabase::class.java, "movie-database"
        ).build()
    }
}