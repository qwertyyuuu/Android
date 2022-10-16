package com.example.homework3

import androidx.fragment.app.Fragment
import com.example.homework3.databinding.Screen1MainBinding

class Screen2 : Fragment(R.layout.screen2_main) {
    private var _binding: Screen1MainBinding? = null
    private val binding get() = _binding!!

    companion object {
        const val SECOND_FRAGMENT_TAG = "SECOND_FRAGMENT_TAG"

        fun getInstance(): Screen2 = Screen2()
    }

}