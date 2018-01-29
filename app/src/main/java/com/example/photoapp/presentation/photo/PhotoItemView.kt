package com.example.photoapp.presentation.photo

import android.app.Activity
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.View
import android.view.Window
import butterknife.ButterKnife
import com.example.photoapp.R


class PhotoItemView {

    var dialog: Dialog? = null

    var activity: Activity? = null

    private val photoItemListener: PhotoItemListener by lazy { activity as PhotoItemListener }

    interface PhotoItemListener {

    }

    fun showColorPickerView(activity: Activity?) {
        dialog = Dialog(activity)
        this.activity = activity

        val view = View.inflate(activity?.applicationContext, R.layout.photo_item_layout, null)
        dialog?.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog?.setCancelable(false)
        dialog?.setContentView(view)
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        ButterKnife.bind(this, view)



        dialog?.show()
    }
}
