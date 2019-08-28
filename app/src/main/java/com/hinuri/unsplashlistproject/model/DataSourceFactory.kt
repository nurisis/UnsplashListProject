package com.hinuri.unsplashlistproject.model

import androidx.paging.DataSource
import com.hinuri.unsplashlistproject.item.UnsplashItem

class DataSourceFactory() : DataSource.Factory<Int,UnsplashItem>() {

    override fun create(): DataSource<Int, UnsplashItem> {
        return com.hinuri.unsplashlistproject.model.DataSource()
    }
}