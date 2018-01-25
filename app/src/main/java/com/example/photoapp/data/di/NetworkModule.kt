package com.example.photoapp.data.di

import com.example.photoapp.BuildConfig
import com.example.photoapp.data.api.PhotoApi
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * Created by Sergey Panshyn on 03.11.2017.
 */
@Module
class NetworkModule {

    @Singleton
    @Provides
    internal fun provideOkHttp(): OkHttpClient {
        return OkHttpClient.Builder()
                .readTimeout(10.toLong(), TimeUnit.SECONDS)
                .build()
    }

    @Singleton
    @Provides
    internal fun provideRetrofit(client: OkHttpClient, gson: Gson): Retrofit {
        return Retrofit.Builder()
                .baseUrl(BuildConfig.FLICKR_BASE_URL)
                .client(client)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
    }

    @Singleton
    @Provides
    internal fun provideGson(): Gson {
        return GsonBuilder()
                .setLenient()
                .create()
    }

    @Singleton
    @Provides
    fun provideVideosApi(retrofit: Retrofit) = retrofit.create(PhotoApi::class.java)

}