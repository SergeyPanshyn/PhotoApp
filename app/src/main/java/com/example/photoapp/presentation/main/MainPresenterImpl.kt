package com.example.photoapp.presentation.main

/**
 * Created by Sergey Panshyn on 10.11.2017.
 */
class MainPresenterImpl<T: MainPresenter.MainView>: MainPresenter<T> {

    private var view: T? = null

    override fun setView(view: T) {
        this.view = view
    }

    override fun destroy() {
        this.view = null
    }

}