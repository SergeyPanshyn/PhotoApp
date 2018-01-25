package com.example.photoapp.data.di

import android.content.Context
import android.preference.PreferenceManager
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Sergey Panshyn on 03.11.2017.
 */

@Module(includes = arrayOf(RepositoriesModule::class, NetworkModule::class))
class DataModule {

    @Provides
    @Singleton
    fun provideShared(context: Context) = PreferenceManager.getDefaultSharedPreferences(context)

}