package com.example.photoapp.extention

import android.app.Activity
import android.util.DisplayMetrics

/**
 * Created by Sergey Panshyn on 09.11.2017.
 */
fun Activity.getScreenHeight(): Int {
    val displayMetrics = DisplayMetrics()
    this.windowManager.defaultDisplay.getMetrics(displayMetrics)
    return displayMetrics.heightPixels
}

