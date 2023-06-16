package com.example.moviesapp.di

import com.example.moviesapp.ui.adapter.PlaylistAdapter
import dagger.Module
import dagger.Provides

@Module
class PlaylistBottomSheetModule {

    @Provides
    fun providePlaylistAdapter() = PlaylistAdapter()
}