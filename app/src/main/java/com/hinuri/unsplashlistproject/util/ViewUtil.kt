package com.hinuri.unsplashlistproject.util

import android.graphics.Color
import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide


object ViewUtil {

    // Set a image with a url - using on layout file.
    @BindingAdapter("imageUrl")
    @JvmStatic
    fun loadImage(imageView: ImageView, url: String) {
        Glide.with(imageView.context)
            .load(url)
            .into(imageView)
    }

}