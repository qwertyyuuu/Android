package com.example.homework4

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.homework4.databinding.Fragment1Binding
import com.example.homework4.databinding.Fragment2Binding

class Fragment2: Fragment(R.layout.fragment2) {
    private lateinit var binding: Fragment2Binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) {
        binding = Fragment2Binding.inflate(inflater,container,false)
    }

    companion object {
        const val SECOND_FRAGMENT_TAG = "SECOND_FRAGMENT_TAG"
        fun getInstance(): Fragment2 = Fragment2()
    }



