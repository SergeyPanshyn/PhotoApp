package com.example.photoapp.presentation.main.di

import com.example.photoapp.presentation.di.PerActivity
import com.example.photoapp.presentation.main.MainActivity
import dagger.Subcomponent

/**
 * Created by Sergey Panshyn on 10.11.2017.
 */
@PerActivity
@Subcomponent(modules = arrayOf(MainModule::class))
interface MainComponent {

    fun inject(mainActivity: MainActivity)

}