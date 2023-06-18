package com.example.moviesapp.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.moviesapp.ui.AddPlaylistDialog
import com.example.moviesapp.ui.MainActivity
import com.example.moviesapp.ui.PlaylistBottomSheet
import com.example.moviesapp.viewmodel.MovieViewModel
import dagger.Binds
import dagger.MapKey
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton
import kotlin.reflect.KClass

@Module(includes = [MovieViewModelModule::class])
abstract class MainActivityModule {
    @ActivityScope
    @ContributesAndroidInjector(modules = [ActivityModule::class])
    abstract fun contributeMainActivity(): MainActivity
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

@Module
abstract class MovieViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(MovieViewModel::class)
    internal abstract fun bindsViewModel(viewModel: MovieViewModel): ViewModel
}

@Suppress("UNCHECKED_CAST")
@Singleton
class AppViewModelFactory @Inject constructor(private val creators: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        var creator: Provider<out ViewModel>? = creators[modelClass]
        if (creator == null) {
            //Check if there is a subclass of ViewModel of type T
            for ((key, value) in creators) {
                if (modelClass.isAssignableFrom(key)) {
                    creator = value
                    break
                }
            }
        }
        if (creator == null) {
            throw IllegalArgumentException("unknown model class $modelClass")
        }
        try {
            return creator.get() as T
        } catch (e: Exception) {
            throw RuntimeException(e)
        }

    }
}

@MustBeDocumented
@Retention
@Target(
    AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER
)
@MapKey
annotation class ViewModelKey(val value: KClass<out ViewModel>)