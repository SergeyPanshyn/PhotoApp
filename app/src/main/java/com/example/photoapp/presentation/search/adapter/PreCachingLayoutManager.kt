package com.example.photoapp.presentation.search.adapter

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView



/**
 * Created by Sergey Panshyn on 09.11.2017.
 */
class PreCachingLayoutManager(val context: Context) : LinearLayoutManager(context) {
    private var extraLayoutSpace = -1

    fun setExtraLayoutSpace(extraLayoutSpace: Int) {
        this.extraLayoutSpace = extraLayoutSpace
    }

    override fun getExtraLayoutSpace(state: RecyclerView.State): Int {
        return if (extraLayoutSpace > 0) {
            extraLayoutSpace
        } else DEFAULT_EXTRA_LAYOUT_SPACE
    }

    companion object {
        private val DEFAULT_EXTRA_LAYOUT_SPACE = 600
    }
}