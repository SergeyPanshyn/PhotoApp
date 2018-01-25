package com.example.photoapp.presentation

/**
 * Created by Sergey Panshyn on 03.11.2017.
 */
interface Presenter<T> {

    fun setView(view: T)

    fun destroy()
}