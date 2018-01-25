package com.example.photoapp.domain.schedulers

import rx.Scheduler

/**
 * Created by Sergey Panshyn on 03.11.2017.
 */
interface SubscribeOn {

    val scheduler: Scheduler

}