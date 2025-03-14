package com.example.viewpager2

import android.icu.text.Transliterator.Position
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.example.viewpager2.databinding.FragmentMainBinding


import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class FragmentMain:Fragment (){

    lateinit var  binding: FragmentMainBinding
    private lateinit var viewPager: ViewPager2
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewPager = binding.viewPage

        val adapter = ViewPagerAdapter(requireActivity())
        viewPager.adapter = adapter



        val dss = mutableListOf<String>()
        dss.add("  song  ")
        dss.add("  math  ")
        dss.add("  logo  ")

        val tabAdapter = RvTabAdapter(dss) { position ->
            binding.viewPage.currentItem = position // Chuyển trang ViewPager2 khi bấm tab
        }


        binding.rvTabbbbb.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.rvTabbbbb.adapter=tabAdapter

        binding.viewPage.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                tabAdapter.setSelectedPosition(position) // Cập nhật tab khi vuốt
            }
        })

//        val tabLayout: TabLayout = view.findViewById(R.id.tap_layout)
//        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
//            tab.text = when (position) {
//                0 -> "Home"
//                1 -> "Profile"
//                2 -> "Settings"
//                else -> "Tab"
//            }
//        }.attach()

    }
}