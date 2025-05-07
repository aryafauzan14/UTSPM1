package com.example.utspm1

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView
import android.widget.BaseAdapter
import android.widget.ImageView



    class TicketAdapter(private val context: Context, private val ticketImages: Array<Int>) : BaseAdapter() {
        override fun getCount() = ticketImages.size
        override fun getItem(position: Int) = ticketImages[position]
        override fun getItemId(position: Int) = position.toLong()

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val imageView = ImageView(context)
            imageView.setImageResource(ticketImages[position])
            imageView.layoutParams = AbsListView.LayoutParams(400, 400) // Tiket lebih besar tampilannya
            imageView.scaleType = ImageView.ScaleType.CENTER_CROP
            imageView.setPadding(16, 16, 16, 16)
            return imageView
        }
    }

