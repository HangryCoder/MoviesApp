package com.example.moviesapp.di

import androidx.lifecycle.ViewModelProvider
import com.example.moviesapp.ui.AddPlaylistDialog
import com.example.moviesapp.ui.MainActivity
import com.example.moviesapp.ui.PlaylistBottomSheet
import com.example.moviesapp.ui.adapter.MovieAdapter
import com.example.moviesapp.viewmodel.AppViewModelFactory
import com.example.moviesapp.viewmodel.MovieViewModel
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector

@Module(includes = [MainActivityFragmentsModule::class])
class MainActivityModule {

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

@Module
abstract class MainActivityFragmentsModule {

    @FragmentScope
    @ContributesAndroidInjector(modules = [PlaylistBottomSheetModule::class])
    abstract fun contributePlaylistBottomSheet(): PlaylistBottomSheet

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun contributeAddPlaylistDialog(): AddPlaylistDialog
}