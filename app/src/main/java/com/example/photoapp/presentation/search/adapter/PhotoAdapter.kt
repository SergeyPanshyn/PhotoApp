package com.example.photoapp.presentation.search.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.photoapp.R
import com.example.photoapp.data.api.models.PhotoItem
import com.squareup.picasso.Picasso

/**
 * Created by Sergey Panshyn on 03.11.2017.
 */
class PhotoAdapter(val context: Context, var data: List<PhotoItem>): RecyclerView.Adapter<PhotoViewHolder>() {

    var layoutInflater: LayoutInflater? = null

    override fun onBindViewHolder(holder: PhotoViewHolder?, position: Int) {
        val currentData = data[position]
        Picasso.with(context).load(currentData.imageUrl).into(holder?.mainIv)
        holder?.photoName?.text = currentData.title
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): PhotoViewHolder {
        layoutInflater = LayoutInflater.from(context)
        val view = layoutInflater!!.inflate(R.layout.photo_item, parent, false)
        return PhotoViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

}