package com.example.photoapp.presentation.search

import android.support.v7.widget.RecyclerView

/**
 * Created by Sergey Panshyn on 26.01.2018.
 */
class OnScrollListener(val context: SearchFragment): RecyclerView.OnScrollListener() {

    private val presetListListener by lazy { context as OnScrollListener.OnScrollListenerCallback }

    override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)
        if (dy > 0) {
            presetListListener.onScrollingDown()
            if (!recyclerView!!.canScrollVertically(RecyclerView.FOCUS_DOWN)) {
                presetListListener.onScrolledTillTheEnd()
            }
        } else if (dy<0) {
            presetListListener.onScrollingUp()
        }
    }

    interface OnScrollListenerCallback {

        fun onScrollingDown()

        fun onScrollingUp()

        fun onScrolledTillTheEnd()

    }

}