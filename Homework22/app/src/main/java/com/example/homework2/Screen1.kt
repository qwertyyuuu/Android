package com.example.homework2

import android.os.Bundle
import android.system.Os.bind
import android.view.View
import androidx.databinding.DataBindingUtil.bind
import androidx.fragment.app.Fragment


class Screen1 : Fragment(R.layout.screen1_main) {
    private var _binding: Screen1? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = Screen1.bind(view)
        val fragmentManager = activity?.supportFragmentManager
    }
}
