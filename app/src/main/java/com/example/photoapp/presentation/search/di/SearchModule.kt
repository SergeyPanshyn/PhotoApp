package com.example.photoapp.presentation.search.di

import com.example.photoapp.data.repository.PhotoRepository
import com.example.photoapp.domain.photos.GetPhotoInfoUseCase
import com.example.photoapp.domain.photos.GetPhotosUseCase
import com.example.photoapp.domain.schedulers.ObserveOn
import com.example.photoapp.domain.schedulers.SubscribeOn
import com.example.photoapp.presentation.di.PerActivity
import com.example.photoapp.presentation.search.SearchPresenter
import com.example.photoapp.presentation.search.SearchPresenterImpl
import dagger.Module
import dagger.Provides

/**
 * Created by Sergey Panshyn on 03.11.2017.
 */
@Module
class SearchModule {

    @Provides
    @PerActivity
    fun provideFeaturedPresenter(getPhotosUseCase: GetPhotosUseCase,
                                 getPhotoInfoUseCase: GetPhotoInfoUseCase): SearchPresenter<SearchPresenter.FeaturedView> = SearchPresenterImpl(getPhotosUseCase, getPhotoInfoUseCase)

    @Provides
    @PerActivity
    fun provideGetPhotosUseCase(subscribeOn: SubscribeOn, observeOn: ObserveOn, photoRepository: PhotoRepository) = GetPhotosUseCase(subscribeOn, observeOn, photoRepository)

    @Provides
    @PerActivity
    fun provideGetPhotoInfoUseCase(subscribeOn: SubscribeOn, observeOn: ObserveOn, photoRepository: PhotoRepository) = GetPhotoInfoUseCase(observeOn, subscribeOn, photoRepository)

}