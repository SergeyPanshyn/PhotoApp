package com.example.photoapp.presentation.search.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.photoapp.R
import com.example.photoapp.data.api.models.PhotoItem

/**
 * Created by Sergey Panshyn on 03.11.2017.
 */
class PhotoAdapter(val context: Context, var data: List<PhotoItem>, val itemClickListener: View.OnClickListener): RecyclerView.Adapter<PhotoViewHolder>() {

    var layoutInflater: LayoutInflater? = null

    override fun onBindViewHolder(holder: PhotoViewHolder?, position: Int) {
        val currentData = data[position]
        holder?.photoName?.text = currentData.title
        Glide.with(context).load(currentData.imageUrl).into(holder?.mainIv!!)

    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): PhotoViewHolder {
        layoutInflater = LayoutInflater.from(context)
        val view = layoutInflater!!.inflate(R.layout.photo_item, parent, false)
        return PhotoViewHolder(view, itemClickListener)
    }

    override fun getItemCount(): Int {
        return data.size
    }

}