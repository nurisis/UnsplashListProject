package com.hinuri.unsplashlistproject.adapter

import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import com.hinuri.unsplashlistproject.item.UnsplashItem
import androidx.recyclerview.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.view.LayoutInflater
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
        }
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<UnsplashItem>(){
            override fun areItemsTheSame(oldItem: UnsplashItem, newItem: UnsplashItem): Boolean {
                return true
            }

            override fun areContentsTheSame(oldItem: UnsplashItem, newItem: UnsplashItem): Boolean {
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
