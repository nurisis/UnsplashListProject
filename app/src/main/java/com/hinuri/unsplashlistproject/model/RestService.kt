package com.hinuri.unsplashlistproject.model

import com.hinuri.unsplashlistproject.Constant
import com.hinuri.unsplashlistproject.item.UnsplashItem
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query


interface RestService {
    @Headers("Authorization: Client-ID " + Constant.UNSPLASH_ACCESS_KEY)
    @GET("photos/")
    fun getUnsplashData(@Query("page") page:Int)
            : Call<List<UnsplashItem>>
}