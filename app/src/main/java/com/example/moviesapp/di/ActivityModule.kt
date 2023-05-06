package com.example.moviesapp.di

import com.example.moviesapp.ui.adapter.MovieAdapter
import dagger.Module
import dagger.Provides

@Module
class ActivityModule {

    @Provides
    fun provideAdapter(): MovieAdapter = MovieAdapter()
}