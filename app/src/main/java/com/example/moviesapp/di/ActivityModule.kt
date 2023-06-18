package com.example.moviesapp.di

import androidx.lifecycle.ViewModelProvider
import com.example.moviesapp.ui.MainActivity
import com.example.moviesapp.ui.adapter.MovieAdapter
import com.example.moviesapp.viewmodel.MovieViewModel
import dagger.Module
import dagger.Provides

@Module(includes = [MainActivityFragmentsModule::class])
class ActivityModule {

    @ActivityScope
    @Provides
    fun provideMoviesViewModel(
        activity: MainActivity,
        factory: AppViewModelFactory
    ): MovieViewModel {
        return ViewModelProvider(activity, factory)[MovieViewModel::class.java]
    }

    @Provides
    fun provideAdapter(): MovieAdapter = MovieAdapter()
}