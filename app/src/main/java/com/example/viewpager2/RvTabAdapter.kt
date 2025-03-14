package com.example.viewpager2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.viewpager2.databinding.ItemTabBinding



class RvTabAdapter (private val tabs: List<String>, // Danh sách tiêu đề tab
        private val onTabClick: (Int) -> Unit // Sự kiện khi click vào tab
) : RecyclerView.Adapter<RvTabAdapter.ViewHolder>() {

    private var selectedPosition =0;
    inner class ViewHolder(val binding: ItemTabBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemTabBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = tabs[position]

        if(position==selectedPosition){
            holder.binding.txtTab.setBackgroundResource(R.drawable.rounded_rectangle2)
        }
        else {
            holder.binding.txtTab.setBackgroundResource(R.drawable.rounded_rectangle)
        }
        holder.binding.apply {
            txtTab.text=item
        }
        holder.itemView.setOnClickListener{
            setSelectedPosition(position)
            onTabClick.invoke(position)
        }
    }


//    var ds: List<Contact>, val onclick: (Contact) -> Unit) : RecyclerView.Adapter<RvAdapter.PeopleHolder>()
override fun getItemCount(): Int = tabs.size

    fun setSelectedPosition(position: Int) {
        if (selectedPosition != position) {
            val oldPosition = selectedPosition
            selectedPosition = position
            notifyItemChanged(oldPosition) // Cập nhật tab cũ
            notifyItemChanged(selectedPosition) // Cập nhật tab mới
        }
    }
}