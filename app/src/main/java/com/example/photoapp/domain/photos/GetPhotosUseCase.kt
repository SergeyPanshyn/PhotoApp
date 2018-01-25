package com.example.photoapp.domain.photos

import com.example.photoapp.data.api.models.PhotoResponse
import com.example.photoapp.data.repository.PhotoRepository
import com.example.photoapp.domain.base.UseCaseObservable
import com.example.photoapp.domain.schedulers.ObserveOn
import com.example.photoapp.domain.schedulers.SubscribeOn
import rx.Observable

/**
 * Created by Sergey Panshyn on 06.11.2017.
 */
class GetPhotosUseCase(subscribeOn: SubscribeOn, observeOn: ObserveOn, val photoRepository: PhotoRepository): UseCaseObservable<PhotoResponse>(subscribeOn, observeOn) {
    override val useCaseObservable: Observable<PhotoResponse>
        get() = photoRepository.getPhotos(searchTag, offset)

    var searchTag: String = ""
    var offset: Int = 0
}