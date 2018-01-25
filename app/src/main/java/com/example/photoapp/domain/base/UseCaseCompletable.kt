package com.example.photoapp.domain.base

import com.example.photoapp.domain.schedulers.ObserveOn
import com.example.photoapp.domain.schedulers.SubscribeOn
import rx.Completable

/**
 * Created by Sergey Panshyn on 03.11.2017.
 */
abstract class UseCaseCompletable(subscribeOn: SubscribeOn, observeOn: ObserveOn) : UseCase(subscribeOn, observeOn) {

    protected var completable: Completable? = null

    fun executeCompletable(onComplete: () -> Unit, onError: (Throwable) -> Unit) {
        if (completable == null) {
            completable = useCaseCompletable
                    .subscribeOn(subscribeOn.scheduler)
                    .observeOn(observeOn.scheduler)
                    .doOnError { completable = null }
                    .doOnCompleted { completable = null }
        }
    }

    protected abstract val useCaseCompletable: Completable
}