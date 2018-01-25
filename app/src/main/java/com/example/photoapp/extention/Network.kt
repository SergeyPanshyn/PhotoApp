package com.example.photoapp.extention

import android.content.Context
import android.net.ConnectivityManager

/**
 * Created by Sergey Panshyn on 06.11.2017.
 */

fun Context.isNetworkAvialable(): Boolean {
    val connectivityManager = this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val activeNetworkInfo = connectivityManager.activeNetworkInfo
    return activeNetworkInfo != null && activeNetworkInfo.isConnected
}