package com.example.moviesapp.di

import androidx.fragment.app.DialogFragment
import com.example.moviesapp.ui.MainActivity
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [ActivityModule::class])
interface ActivityComponent {
    @Subcomponent.Factory
    interface Factory {
        fun create(): ActivityComponent
    }

    fun inject(activity: MainActivity)
    //fun inject(dialog: BottomSheetDialogFragment)
}