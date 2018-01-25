package com.example.photoapp.domain.base

import com.example.photoapp.domain.schedulers.ObserveOn
import com.example.photoapp.domain.schedulers.SubscribeOn
import rx.subscriptions.Subscriptions

/**
 * Created by Sergey Panshyn on 03.11.2017.
 */
open class UseCase(protected var subscribeOn: SubscribeOn, protected var observeOn: ObserveOn) {

    protected var subscription = Subscriptions.empty()

    fun unsubscribe() {
        if (!subscription.isUnsubscribed){
            subscription.unsubscribe()
        }
    }


}