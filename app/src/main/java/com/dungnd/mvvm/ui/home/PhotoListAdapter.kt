package com.dungnd.mvvm.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dungnd.mvvm.data.remote.model.Photo
import com.dungnd.mvvm.databinding.ItemPhotoBinding
import com.dungnd.mvvm.util.setOnSingClickListener

class PhotoListAdapter : RecyclerView.Adapter<PhotoListAdapter.PhotoViewHolder>() {
    inner class PhotoViewHolder constructor(private val binding: ItemPhotoBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(photo: Photo?) {
            Glide.with(itemView.context).load("https://via.placeholder.com/150/771796").into(binding.ivImage)
            binding.tvTitle.text = photo?.title
        }
    }

    var photoList: List<Photo>? = null
    var onPhotoClick: ((Photo?) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val binding = ItemPhotoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PhotoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        holder.bind(photoList?.get(position))
        holder.itemView.setOnSingClickListener {
            onPhotoClick?.invoke(photoList?.get(position))
        }
    }

    override fun getItemCount(): Int = photoList?.size ?: 0
}