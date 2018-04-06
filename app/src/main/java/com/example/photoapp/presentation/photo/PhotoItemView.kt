package com.example.photoapp.presentation.photo

import android.app.Activity
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.View
import android.view.Window
import android.widget.ImageView
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import com.bumptech.glide.Glide
import com.example.photoapp.R
import com.example.photoapp.data.api.models.Photo
import com.example.photoapp.data.api.models.PhotoItemResponse
import de.hdodenhof.circleimageview.CircleImageView


class PhotoItemView {

    var dialog: Dialog? = null

    var activity: Activity? = null

    private val photoItemListener: PhotoItemListener by lazy { activity as PhotoItemListener }

    @BindView(R.id.user_img_1)
    lateinit var user_img_1: CircleImageView

    @BindView(R.id.user_name_1)
    lateinit var user_name_1: TextView

    @BindView(R.id.main_img_1)
    lateinit var main_img_1: ImageView

    @BindView(R.id.photo_name_1)
    lateinit var photo_name_1: TextView

    @BindView(R.id.faves_count_1)
    lateinit var faves_count_1: TextView

    @BindView(R.id.comments_count_1)
    lateinit var commentsCount1: TextView

    @BindView(R.id.views_count_1)
    lateinit var views_count_1: TextView

    interface PhotoItemListener {

    }

    fun showColorPickerView(activity: Activity?, data: PhotoItemResponse) {
        dialog = Dialog(activity)
        this.activity = activity

        val view = View.inflate(activity?.applicationContext, R.layout.photo_item_layout, null)
        dialog?.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog?.setCancelable(true)
        dialog?.setContentView(view)
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        ButterKnife.bind(this, view)

        setData(data.photo)

        dialog?.show()
    }

    private fun setData(photo: Photo) {
        user_name_1.text = photo.owner.username
//        Glide.with(activity!!).load(photo.owner).into(user_img_1)
        Glide.with(activity!!).load(photo.imageUrl).into(main_img_1)
        photo_name_1.text = photo.title.content
//        faves_count_1.text = photo.comments + " Faves"
        commentsCount1.text = photo.comments.content.toString() + " Comments"
        views_count_1.text = photo.views + " Views"
    }


}
