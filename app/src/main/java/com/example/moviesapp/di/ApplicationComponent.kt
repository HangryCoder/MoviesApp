package com.example.moviesapp.di

import android.app.Application
import com.example.moviesapp.MyApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AndroidInjectionModule::class, ActivityModule::class,/* SubcomponentsModule::class,*/ ApplicationModule::class]
)
interface ApplicationComponent  {
    //fun activityComponent(): ActivityComponent.Factory

    /*@Component.Builder
    interface Builder {
        fun build(): ApplicationComponent

        @BindsInstance
        fun application(application: Application): Builder
    }*/

     fun inject(application: MyApplication)
}