package com.example.moviesapp

import android.app.Application
import com.example.moviesapp.di.ApplicationComponent
//import com.example.moviesapp.di.ApplicationModule
import com.example.moviesapp.di.DaggerApplicationComponent
import com.example.moviesapp.di.NetworkModule

class MyApplication : Application() {

    private val BASE_URL = "https://api.themoviedb.org/"

    val appComponent: ApplicationComponent by lazy {
        DaggerApplicationComponent.builder().networkModule(NetworkModule(BASE_URL))
            //.applicationModule(ApplicationModule(applicationContext))
            .build()
    }

}