package com.example.photoapp.domain.base

import com.example.photoapp.domain.schedulers.ObserveOn
import com.example.photoapp.domain.schedulers.SubscribeOn
import rx.Observable
import rx.Subscriber

/**
 * Created by Sergey Panshyn on 03.11.2017.
 */
abstract class UseCaseObservable<T>(subscribeOn: SubscribeOn, observeOn: ObserveOn) : UseCase(subscribeOn, observeOn) {

    private var observable: Observable<T>? = null

    fun executeObservable(subscriber: Subscriber<T>) {
        if (observable == null) {
            observable = useCaseObservable
                    .subscribeOn(subscribeOn.scheduler)
                    .observeOn(observeOn.scheduler)
                    .doOnError { observable = null }
                    .doOnCompleted { observable = null }
                    .doOnUnsubscribe { observable = null }
        }
        subscription = observable?.subscribe(subscriber)
    }

    protected abstract val useCaseObservable: Observable<T>

}