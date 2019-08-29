package com.hinuri.unsplashlistproject.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.hinuri.unsplashlistproject.R
import com.hinuri.unsplashlistproject.adapter.UnsplashAdapter
import com.hinuri.unsplashlistproject.viewmodel.UnsplashViewModel
import kotlinx.android.synthetic.main.activity_show_list.*

class ShowListActivity : AppCompatActivity() {

    val unsplashAdapter = UnsplashAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_list)

        // set a toolbar
        setSupportActionBar(toolbar)

        recyclerView.run {
            adapter = unsplashAdapter
            val staggeredGridLayoutManager = StaggeredGridLayoutManager(2,1)
            layoutManager = staggeredGridLayoutManager
            itemAnimator = null
        }

        // Set a view model
        val viewModel = ViewModelProviders.of(this).get(UnsplashViewModel::class.java)
        viewModel.unsplashLiveData.observe(this, Observer {
                list -> unsplashAdapter.submitList(list)
        })

    }
}
