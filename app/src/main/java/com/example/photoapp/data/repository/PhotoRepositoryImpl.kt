package com.example.photoapp.data.repository

import android.content.Context
import com.example.photoapp.BuildConfig
import com.example.photoapp.data.api.PhotoApi
import com.example.photoapp.data.api.models.PhotoItemResponse
import com.example.photoapp.data.api.models.PhotoResponse
import com.example.photoapp.extention.isNetworkAvialable
import rx.Observable
import rx.schedulers.Schedulers

/**
 * Created by Sergey Panshyn on 06.11.2017.
 */

class PhotoRepositoryImpl(private val context: Context, private val photoApi: PhotoApi) : PhotoRepository {

    companion object {
        val methodGetPhotos = "flickr.photos.search"

        val methodGetPhotoInfo = "flickr.photos.getInfo"

        val photoCount = 10
    }

    override fun getPhotos(searchTag: String, offset: Int): Observable<PhotoResponse> {
        if (!context.isNetworkAvialable())
            return Observable.empty()

        return photoApi.getPhotos(BuildConfig.FLICKR_API_KEY, methodGetPhotos, searchTag, photoCount, offset)
                .subscribeOn(Schedulers.newThread())
    }

    override fun getPhotoInfo(photoId: String): Observable<PhotoItemResponse> {
        if (!context.isNetworkAvialable())
            return Observable.empty()

        return photoApi.getPhotoInfo(BuildConfig.FLICKR_API_KEY, methodGetPhotoInfo, photoId)
                .subscribeOn(Schedulers.newThread())
    }

}