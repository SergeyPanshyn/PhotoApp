package com.example.photoapp.data.repository

import com.example.photoapp.data.api.models.PhotoResponse
import rx.Observable

/**
 * Created by Sergey Panshyn on 06.11.2017.
 */

interface PhotoRepository {

    fun getPhotos(searchTag: String): Observable<PhotoResponse>

}