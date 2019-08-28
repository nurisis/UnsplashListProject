package com.hinuri.unsplashlistproject.adapter

import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import com.hinuri.unsplashlistproject.item.UnsplashItem
import androidx.core.content.ContextCompat.startActivity
import android.content.Intent
import android.os.AsyncTask.THREAD_POOL_EXECUTOR
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.view.LayoutInflater
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.hinuri.unsplashlistproject.R
import com.hinuri.unsplashlistproject.databinding.UnsplashItemBinding


class UnsplashAdapter() : PagedListAdapter<UnsplashItem, UnsplashAdapter.ViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.unsplash_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item : UnsplashItem? = getItem(position)
        item?.let {
            holder.binding.item = item

//            Glide.with(holder.itemView).load(item.urls.thumb).into(holder.binding.imageView)
        }
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<UnsplashItem>(){
            override fun areItemsTheSame(oldItem: UnsplashItem, newItem: UnsplashItem): Boolean {
                //TODO ::
                return true
            }

            override fun areContentsTheSame(oldItem: UnsplashItem, newItem: UnsplashItem): Boolean {
                //TODO ::
                return true
            }
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val binding : UnsplashItemBinding
        init {
            binding = UnsplashItemBinding.bind(itemView)
        }

    }
}
