package com.example.photoapp.domain.photos

import com.example.photoapp.data.api.models.PhotoItemResponse
import com.example.photoapp.data.repository.PhotoRepository
import com.example.photoapp.domain.base.UseCaseObservable
import com.example.photoapp.domain.schedulers.ObserveOn
import com.example.photoapp.domain.schedulers.SubscribeOn
import rx.Observable

/**
 * Created by Sergey Panshyn on 07.02.2018.
 */
class GetPhotoInfoUseCase(observeOn: ObserveOn, subscribeOn: SubscribeOn, private val photoRepository: PhotoRepository): UseCaseObservable<PhotoItemResponse>(subscribeOn, observeOn) {
    override val useCaseObservable: Observable<PhotoItemResponse>
        get() = photoRepository.getPhotoInfo(photoId)

    var photoId: String = ""
}