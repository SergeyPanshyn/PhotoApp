package com.example.photoapp.presentation.main.di

import com.example.photoapp.presentation.di.PerActivity
import com.example.photoapp.presentation.main.MainPresenter
import com.example.photoapp.presentation.main.MainPresenterImpl
import dagger.Module
import dagger.Provides

/**
 * Created by Sergey Panshyn on 10.11.2017.
 */
@Module
class MainModule {

    @Provides
    @PerActivity
    fun provideMainPresenter(): MainPresenter<MainPresenter.MainView> = MainPresenterImpl()

}