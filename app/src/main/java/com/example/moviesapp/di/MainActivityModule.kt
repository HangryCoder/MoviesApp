package com.example.moviesapp.di

import com.example.moviesapp.ui.MainActivity
import com.example.moviesapp.ui.PlaylistBottomSheet
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(includes = [BottomSheetModule::class])
abstract class MainActivityModule {
    @ActivityScope
    @ContributesAndroidInjector(modules = [ActivityModule::class])
    abstract fun contributeMainActivity(): MainActivity
}

@Module
abstract class BottomSheetModule {

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun contributePlaylistBottomSheet(): PlaylistBottomSheet
}