package com.example.photoapp.presentation.search.adapter_favor

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import com.example.photoapp.R

/**
 * Created by Sergey Panshyn on 25.01.2018.
 */
class FavorViewHolder(itemView: View, val onItemClick: View.OnClickListener): RecyclerView.ViewHolder(itemView) {

    @BindView(R.id.favor_tags_item_text)
    lateinit var text: TextView

    init {
        ButterKnife.bind(this, itemView)

        text.setOnClickListener {
            it.tag = adapterPosition
            onItemClick.onClick(it)
        }
    }

}