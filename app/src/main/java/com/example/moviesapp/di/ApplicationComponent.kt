package com.example.moviesapp.di

import com.example.moviesapp.MyApplication
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AndroidInjectionModule::class, ActivityModule::class, ApplicationModule::class]
)
interface ApplicationComponent {
    fun inject(application: MyApplication)
}