package com.example.moviesapp.di

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [NetworkModule::class, SubcomponentsModule::class, DatabaseModule::class, ApplicationModule::class]
)
interface ApplicationComponent {
    fun activityComponent(): ActivityComponent.Factory
}