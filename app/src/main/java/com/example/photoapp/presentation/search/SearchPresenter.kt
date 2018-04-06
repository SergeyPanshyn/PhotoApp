package com.example.photoapp.presentation.search

import com.example.photoapp.data.api.models.PhotoItemResponse
import com.example.photoapp.data.api.models.PhotoResponse
import com.example.photoapp.presentation.Presenter

/**
 * Created by Sergey Panshyn on 03.11.2017.
 */
interface SearchPresenter<T>: Presenter<T> {
    interface FeaturedView {

        fun showPhotos(photoResponse: PhotoResponse)

        fun showPhotoInfo(photoItemResponse: PhotoItemResponse)

    }

    fun getPhotos(searchTag: String, localOffset: Int)

    fun getPhotoInfo(photoId: String)

}