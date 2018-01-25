package com.example.photoapp.presentation.di

import com.example.photoapp.PhotoApplication
import com.example.photoapp.data.di.DataModule
import com.example.photoapp.presentation.main.di.MainComponent
import com.example.photoapp.presentation.main.di.MainModule
import com.example.photoapp.presentation.search.di.SearchComponent
import com.example.photoapp.presentation.search.di.SearchModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by Sergey Panshyn on 03.11.2017.
 */
@Component(modules = arrayOf(AppModule::class, DataModule::class))
@Singleton
interface AppComponent {

    fun getFeaturedComponent(searchModule: SearchModule): SearchComponent

    fun getMainComponent(mainModule: MainModule): MainComponent

    fun inject(photoApplication: PhotoApplication)

}