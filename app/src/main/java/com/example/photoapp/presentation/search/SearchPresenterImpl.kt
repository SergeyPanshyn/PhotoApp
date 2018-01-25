package com.example.photoapp.presentation.search

import android.util.Log
import com.example.photoapp.data.api.models.PhotoResponse
import com.example.photoapp.domain.photos.GetPhotosUseCase
import rx.Subscriber

/**
 * Created by Sergey Panshyn on 03.11.2017.
 */
class SearchPresenterImpl<T: SearchPresenter.FeaturedView>(private val getPhotosUseCase: GetPhotosUseCase): SearchPresenter<T> {

    private var view: T? = null

    override fun getPhotos(searchTag: String) {
        getPhotosUseCase.searchTag = searchTag
        getPhotosUseCase.executeObservable(object : Subscriber<PhotoResponse>() {
            override fun onCompleted() {
                Log.i("onxFeaturedVideos", "connected")
            }

            override fun onError(e: Throwable) {
                Log.i("onxFeaturedVideos", e.toString())
            }

            override fun onNext(photoResponse: PhotoResponse) {
                view?.showPhotos(photoResponse)
            }
        })
    }

    override fun setView(view: T) {
        this.view = view
    }

    override fun destroy() {
        view = null
        getPhotosUseCase.unsubscribe()
    }
}