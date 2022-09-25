package com.example.myapplication

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.Fragment2Binding

class Fragment2 : Fragment (R.layout.fragment_2) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = Fragment2Binding.bind(view)
        var counter = arguments?.getInt("COUNTER") ?: 0

        if (counter == 0)
            binding.textView.visibility = View.INVISIBLE

        if (counter > 0)
            binding.textView.visibility = View.VISIBLE

        binding.textView.text = "count = $counter"

        var imageId = arguments?.getInt("PIC") ?: 0
        if(imageId !== 0)
            binding.imageView.setImageResource(imageId)

    }
}