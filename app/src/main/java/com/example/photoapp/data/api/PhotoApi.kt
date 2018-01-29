package com.example.photoapp.data.api

import com.example.photoapp.data.api.models.PhotoItemResponse
import com.example.photoapp.data.api.models.PhotoResponse
import retrofit2.http.GET
import retrofit2.http.Query
import rx.Observable

/**
 * Created by Sergey Panshyn on 03.11.2017.
 */
interface PhotoApi {

    @GET("/services/rest/?format=json&nojsoncallback=1")
    fun getPhotos(@Query("api_key") api_key: String,
                  @Query("method") method: String,
                  @Query("tags") tags: String,
                  @Query("per_page") per_page: Int,
                  @Query("page") page: Int): Observable<PhotoResponse>

    @GET("/services/rest/?format=json&nojsoncallback=1")
    fun getPhotoInfo(@Query("api_key") api_key: String,
                     @Query("method") method: String,
                     @Query("photo_id") photoId: String): Observable<PhotoItemResponse>

}