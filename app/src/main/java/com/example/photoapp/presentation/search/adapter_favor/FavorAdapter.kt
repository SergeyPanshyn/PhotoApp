package com.example.photoapp.presentation.search.adapter_favor

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.photoapp.R

/**
 * Created by Sergey Panshyn on 25.01.2018.
 */
class FavorAdapter(val context: Context?, val data: List<String>, val onItemClick: View.OnClickListener): RecyclerView.Adapter<FavorViewHolder>() {

    var layoutInflater: LayoutInflater? = null

    override fun onBindViewHolder(holder: FavorViewHolder?, position: Int) {
        holder?.text?.text = data[position]
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): FavorViewHolder {
        layoutInflater = LayoutInflater.from(context)

        val itemView = layoutInflater!!.inflate(R.layout.favor_tags_item, parent, false)

        return FavorViewHolder(itemView, onItemClick)
    }

    override fun getItemCount(): Int {
        return data.size
    }
}