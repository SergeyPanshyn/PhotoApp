package com.example.photoapp.domain.base

import rx.Subscriber

/**
 * Created by Sergey Panshyn on 03.11.2017.
 */
open class DefaultSubscriber<T> : Subscriber<T>() {
    override fun onNext(t: T) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCompleted() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onError(e: Throwable?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}