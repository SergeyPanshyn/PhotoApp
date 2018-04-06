package com.example.photoapp.presentation.search

import android.util.Log
import com.example.photoapp.data.api.models.PhotoItemResponse
import com.example.photoapp.data.api.models.PhotoResponse
import com.example.photoapp.domain.photos.GetPhotoInfoUseCase
import com.example.photoapp.domain.photos.GetPhotosUseCase
import rx.Subscriber

/**
 * Created by Sergey Panshyn on 03.11.2017.
 */
class SearchPresenterImpl<T: SearchPresenter.FeaturedView>(private val getPhotosUseCase: GetPhotosUseCase,
                                                           private val getPhotoInfoUseCase: GetPhotoInfoUseCase): SearchPresenter<T> {

    private var view: T? = null

    override fun getPhotos(searchTag: String, localOffset: Int) {
        getPhotosUseCase.searchTag = searchTag
        getPhotosUseCase.offset = localOffset
        getPhotosUseCase.executeObservable(object : Subscriber<PhotoResponse>() {
            override fun onCompleted() {
                Log.i("getPhotos", "onCompleted")
            }

            override fun onError(e: Throwable) {
                Log.i("getPhotosErr", e.toString())
            }

            override fun onNext(photoResponse: PhotoResponse) {
                view?.showPhotos(photoResponse)
            }
        })
    }

    override fun getPhotoInfo(photoId: String) {
        getPhotoInfoUseCase.photoId = photoId
        getPhotoInfoUseCase.executeObservable(object : Subscriber<PhotoItemResponse>() {
            override fun onNext(t: PhotoItemResponse?) {
                view?.showPhotoInfo(t!!)
            }

            override fun onCompleted() {
                Log.i("getPhotoInfo", "onCompleted")
            }

            override fun onError(e: Throwable?) {
                Log.i("getPhotoInfoErr", e.toString())
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