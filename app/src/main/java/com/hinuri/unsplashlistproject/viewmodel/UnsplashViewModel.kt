package com.hinuri.unsplashlistproject.viewmodel

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.hinuri.unsplashlistproject.Constant
import com.hinuri.unsplashlistproject.item.UnsplashItem
import com.hinuri.unsplashlistproject.model.DataSourceFactory

class UnsplashViewModel : BaseViewModel() {

    // Configuration of paging
    val config = PagedList.Config.Builder()
                    .setInitialLoadSizeHint(Constant.PAGING_SIZE)
                    .setPrefetchDistance(Constant.PAGING_SIZE)
                    .setPageSize(Constant.PAGING_SIZE)
                    .setEnablePlaceholders(true)
                    .build()

    // Live data of unsplash api's list
    val unsplashLiveData : LiveData<PagedList<UnsplashItem>>
            = LivePagedListBuilder(DataSourceFactory(), config).build()

}