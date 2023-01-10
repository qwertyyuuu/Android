package com.example.homework11

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.homework11.databinding.BaseFragmentBinding
import com.example.homework11.settings.SharedPrefManager

class BaseFragment: Fragment(R.layout.base_fragment) {
    private var _binding: BaseFragmentBinding? = null
    private val binding by lazy { _binding!! }
    private var sharedPrefManager: SharedPrefManager? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = BaseFragmentBinding.inflate(layoutInflater)
        sharedPrefManager = SharedPrefManager(binding.root.context)
        setUpOnClickListeners()
        return binding.root
    }


    private fun setUpOnClickListeners() {
        with(binding) {
            buttonLogout.setOnClickListener {
                super.onDestroy()
            }
        }
    }
}