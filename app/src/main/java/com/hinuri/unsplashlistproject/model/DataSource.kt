package com.hinuri.unsplashlistproject.model

import androidx.paging.PageKeyedDataSource
import com.hinuri.unsplashlistproject.Constant
import com.hinuri.unsplashlistproject.item.UnsplashItem
import retrofit2.Retrofit
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.converter.gson.GsonConverterFactory


class DataSource : PageKeyedDataSource<Int,UnsplashItem>() {

    private val restService : RestService? = getRetrofit().create(RestService::class.java)

    // First load
    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, UnsplashItem>) {
        val currentPage = 1
        val nextPage = currentPage +1

        restService?.getUnsplashData(currentPage)!!.enqueue(object : Callback<List<UnsplashItem>> {
            override fun onFailure(call: Call<List<UnsplashItem>>, t: Throwable) {
            }

            override fun onResponse(call: Call<List<UnsplashItem>>, response: Response<List<UnsplashItem>>) {
                callback.onResult(response.body() as MutableList<UnsplashItem>, currentPage, nextPage)
            }
        })
    }

    // After first load
    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, UnsplashItem>) {

        restService?.getUnsplashData(params.key)!!.enqueue(object : Callback<List<UnsplashItem>> {
            override fun onFailure(call: Call<List<UnsplashItem>>, t: Throwable) {
            }

            override fun onResponse(call: Call<List<UnsplashItem>>, response: Response<List<UnsplashItem>>) {
                callback.onResult(response.body() as MutableList<UnsplashItem>, params.key+1)
            }
        })

    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, UnsplashItem>) {
    }


    // Create a retrofit instance
    fun getRetrofit() : Retrofit{
        val client = OkHttpClient.Builder().build()
        val retrofit = Retrofit.Builder().baseUrl(Constant.UNSPLASH_BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return  retrofit
    }
}
