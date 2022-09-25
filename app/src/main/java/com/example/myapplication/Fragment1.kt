package com.example.myapplication

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.Fragment1Binding


class Fragment1 : Fragment(R.layout.fragment_1) {
    private var counter = 0
    private var imageId = R.drawable.ic_launcher_foreground

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = Fragment1Binding.bind(view)
        val fragmentManager = activity?.supportFragmentManager

        with(binding) {
            button1.setOnClickListener {
                fragmentManager?.beginTransaction()?.apply {
                    var fragment = Fragment2()
                    var bundle = Bundle()
                    bundle.putInt("COUNTER", counter)
                    bundle.putInt("PIC", imageId)
                    fragment.arguments = bundle
                    replace(R.id.fragments_container, fragment)

                    addToBackStack("second fragment")
                    commit()

                }
            }
            button2.setOnClickListener {
                counter++
            }
            button3.setOnClickListener {
                if (imageId == R.drawable.ic_launcher_foreground)
                    imageId = R.drawable.ic_android_red_24dp
                else
                    imageId = R.drawable.ic_launcher_foreground
            }
        }
    }
}
