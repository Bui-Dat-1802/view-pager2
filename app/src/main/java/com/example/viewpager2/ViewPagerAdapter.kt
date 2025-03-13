package com.example.viewpager2

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int = 3 // Số lượng trang

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> FragmentSong()
            1 -> FragmentLogo()
            2 -> FragmentMath()
            else -> FragmentSong()
        }
    }
}
