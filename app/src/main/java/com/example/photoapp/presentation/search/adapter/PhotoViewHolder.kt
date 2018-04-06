package com.example.photoapp.presentation.search.adapter

import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import com.example.photoapp.R

/**
 * Created by Sergey Panshyn on 03.11.2017.
 */
class PhotoViewHolder(itemView: View, itemClickListener: View.OnClickListener): RecyclerView.ViewHolder(itemView) {

    @BindView(R.id.user_img)
    lateinit var userIv: ImageView

    @BindView(R.id.root_cv)
    lateinit var rootCv: CardView

    @BindView(R.id.user_name)
    lateinit var userNameTv: TextView

    @BindView(R.id.main_img)
    lateinit var mainIv: ImageView

    @BindView(R.id.photo_name)
    lateinit var photoName: TextView

    @BindView(R.id.faves_count)
    lateinit var favesCountTv: TextView

    @BindView(R.id.comments_count)
    lateinit var commentsCountTv: TextView

    @BindView(R.id.views_count)
    lateinit var viewsCountTv: TextView

    @BindView(R.id.share_button)
    lateinit var shareButton: ImageView

    @BindView(R.id.comment_button)
    lateinit var commentButton: ImageView

    @BindView(R.id.star_button)
    lateinit var starButton: ImageView

    init {
        ButterKnife.bind(this, itemView)

        rootCv.setOnClickListener {
            it.tag = adapterPosition
            itemClickListener.onClick(it)
        }

        shareButton.setOnClickListener {  }
        commentButton.setOnClickListener {  }
        starButton.setOnClickListener {  }
    }

}