package com.example.viewpager2

import android.view.LayoutInflater

import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView
import com.example.viewpager2.databinding.LayoutItemBinding



class RvAdapter(var list_song: MutableList<Item>): RecyclerView.Adapter<RvAdapter.ViewHolder>() {


    inner class ViewHolder(val binding: LayoutItemBinding) : RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = LayoutItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }



    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list_song[position]
        holder.binding.apply {
            imageView.setImageResource(item.image)
        }

    }

    override fun getItemCount(): Int = list_song.size

}