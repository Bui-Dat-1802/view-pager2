package com.example.viewpager2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.viewpager2.databinding.FragmentSongBinding

class FragmentSong : Fragment(){

    lateinit var  binding: FragmentSongBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentSongBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val ds = mutableListOf<Item>()
        ds.add(Item(R.drawable.dog))
        ds.add(Item(R.drawable.dog))
        ds.add(Item(R.drawable.dog))
        ds.add(Item(R.drawable.dog))
        ds.add(Item(R.drawable.dog))
        ds.add(Item(R.drawable.dog))
        ds.add(Item(R.drawable.dog))
        ds.add(Item(R.drawable.dog))
        ds.add(Item(R.drawable.dog))

        binding.rvSong.layoutManager = GridLayoutManager(requireContext(), 2)   //tao 2 cot
        binding.rvSong.adapter=RvAdapter(ds)

    }

}