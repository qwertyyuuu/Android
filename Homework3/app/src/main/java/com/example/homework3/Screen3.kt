package com.example.homework3

import android.os.Bundle
import android.provider.SyncStateContract
import android.view.View
import androidx.fragment.app.Fragment
import com.example.homework3.databinding.Screen1MainBinding

class Screen3 : Fragment(R.layout.screen3_main) {
    private var _binding: Screen1MainBinding? = null
    private val binding get() = _binding!!

    companion object {
        const val THIRD_FRAGMENT_TAG = "THIRD_FRAGMENT_TAG"

        fun getInstance(): Screen3 = Screen3()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }


}
