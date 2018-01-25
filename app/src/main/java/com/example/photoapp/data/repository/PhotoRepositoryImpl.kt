package com.example.photoapp.data.repository

import android.content.Context
import com.example.photoapp.BuildConfig
import com.example.photoapp.data.api.PhotoApi
import com.example.photoapp.data.api.models.PhotoResponse
import com.example.photoapp.extention.isNetworkAvialable
import rx.Observable
import rx.schedulers.Schedulers

/**
 * Created by Sergey Panshyn on 06.11.2017.
 */

class PhotoRepositoryImpl(private val context: Context, private val photoApi: PhotoApi) : PhotoRepository {

    companion object {
        val methodGetPhoto = "flickr.interestingness.getList"

        val photoCount = 10
    }

    override fun getPhotos(searchTag: String): Observable<PhotoResponse> {
        if (!context.isNetworkAvialable())
            return Observable.empty()

        return photoApi.getPhotos(BuildConfig.FLICKR_API_KEY, methodGetPhoto, searchTag, photoCount, photoCount)
                .subscribeOn(Schedulers.newThread())
    }

}