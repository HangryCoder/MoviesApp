package com.example.moviesapp.di

import com.example.moviesapp.ui.AddPlaylistDialog
import com.example.moviesapp.ui.MainActivity
import com.example.moviesapp.ui.PlaylistBottomSheet
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityModule {
    @ActivityScope
    @ContributesAndroidInjector(modules = [ActivityModule::class])
    abstract fun contributeMainActivity(): MainActivity
}

@Module
abstract class MainActivityFragmentsModule {

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun contributePlaylistBottomSheet(): PlaylistBottomSheet

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun contributeAddPlaylistDialog(): AddPlaylistDialog
}