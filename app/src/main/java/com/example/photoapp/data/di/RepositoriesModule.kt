package com.example.photoapp.data.di

import android.content.Context
import com.example.photoapp.data.api.PhotoApi
import com.example.photoapp.data.repository.PhotoRepository
import com.example.photoapp.data.repository.PhotoRepositoryImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Sergey Panshyn on 03.11.2017.
 */

@Module
class RepositoriesModule {

    @Provides
    @Singleton
    fun procideGetVideosRepository(context: Context, photoApi: PhotoApi): PhotoRepository = PhotoRepositoryImpl(context, photoApi)


}