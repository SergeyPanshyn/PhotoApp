package com.example.photoapp.presentation.di

import android.content.Context
import com.example.photoapp.domain.schedulers.ObserveOn
import com.example.photoapp.domain.schedulers.SubscribeOn
import dagger.Module
import dagger.Provides
import rx.Scheduler
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import javax.inject.Singleton

/**
 * Created by Sergey Panshyn on 03.11.2017.
 */
@Module
class AppModule(private val context: Context) {

    @Provides
    @Singleton
    internal fun provideContext(): Context {
        return context
    }

    @Provides
    @Singleton
    internal fun provideSubscribeOn(): SubscribeOn {
        return object : SubscribeOn {
            override val scheduler: Scheduler
                get() = Schedulers.io()

        }
    }

    @Provides
    @Singleton
    internal fun provideObserveOn() : ObserveOn {
        return object : ObserveOn {
            override val scheduler: Scheduler
                get() = AndroidSchedulers.mainThread()

        }
    }

}