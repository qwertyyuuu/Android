package com.example.homework3

import android.os.Bundle
import android.provider.SyncStateContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.homework3.databinding.Screen1MainBinding

class Screen1 : Fragment(R.layout.screen1_main) {
    private var _binding: Screen1MainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = Screen1MainBinding.inflate(inflater, container, false)

        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = Screen1MainBinding.inflate(layoutInflater)
        val fragmentManager = activity?.supportFragmentManager
        (requireActivity() as MainActivity).replaceFragment()
        initClickListeners()
    }

    companion object {
        const val FIRST_FRAGMENT_TAG = "FIRST_FRAGMENT_TAG"
        fun getInstance(): Screen1 = Screen1()
    }

    private fun initClickListeners(){
        with(binding) {
            button1.setOnClickListener{
                val fragment = Screen3.getInstance()
                parentFragmentManager
                    .beginTransaction()
                    .addToBackStack(null)
                    .replace(R.id.fragmentContainerView, fragment)
                    .commit()
            }
            button2.setOnClickListener {
                val count = (1..100).random()
                textView3.text = count.toString()
            }
        }
    }

}

