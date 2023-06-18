package com.example.moviesapp

import android.app.Application
import com.example.moviesapp.di.ApplicationComponent
import com.example.moviesapp.di.DaggerApplicationComponent
import com.example.moviesapp.di.DatabaseModule
import com.example.moviesapp.di.NetworkModule
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class MyApplication : Application(), HasAndroidInjector {

    private val BASE_URL = "https://api.themoviedb.org/"

    lateinit var appComponent: ApplicationComponent

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerApplicationComponent.builder().networkModule(NetworkModule(BASE_URL))
            .databaseModule(DatabaseModule(applicationContext)).build()

        appComponent.inject(this)
    }

    override fun androidInjector(): AndroidInjector<Any> {
        return dispatchingAndroidInjector
    }

}