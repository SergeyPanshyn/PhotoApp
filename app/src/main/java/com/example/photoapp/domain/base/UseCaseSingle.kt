package com.example.photoapp.domain.base

import com.example.photoapp.domain.schedulers.ObserveOn
import com.example.photoapp.domain.schedulers.SubscribeOn
import rx.Single

/**
 * Created by Sergey Panshyn on 03.11.2017.
 */
abstract class UseCaseSingle<T>(subscribeOn: SubscribeOn, observeOn: ObserveOn) : UseCase(subscribeOn, observeOn) {

    private var single: Single<T>? = null

    fun executeSingle(onSuccess: (T) -> Unit, onError: (Throwable) -> Unit) {
        if (single == null){
            single = useCaseSingle
                    .subscribeOn(subscribeOn.scheduler)
                    .observeOn(observeOn.scheduler)
                    .doOnSuccess { single = null }
                    .doOnError { single = null }
        }
    }

    protected abstract val useCaseSingle: Single<T>
}