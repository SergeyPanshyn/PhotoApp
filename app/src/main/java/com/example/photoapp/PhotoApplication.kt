package com.example.photoapp

import android.app.Application
import com.example.photoapp.presentation.di.AppComponent
import com.example.photoapp.presentation.di.AppModule
import com.example.photoapp.presentation.di.DaggerAppComponent

/**
 * Created by Sergey Panshyn on 25.01.2018.
 */
class PhotoApplication : Application() {

    companion object {
        var photoApplication: PhotoApplication? = null
        var appComponent: AppComponent? = null
    }

    override fun onCreate() {
        super.onCreate()

        photoApplication = this
        appComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()
        appComponent?.inject(this)
    }

}