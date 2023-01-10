package com.example.homework11

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.homework11.databinding.RegistrationFragmentBinding

class RegistrationFragment: Fragment(R.layout.registration_fragment) {
    private var _binding: RegistrationFragmentBinding? = null
    private val binding by lazy { _binding!! }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = RegistrationFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClickListeners()
    }

    private fun initClickListeners() {
        with(binding) {
            buttonRegister.setOnClickListener {
                findNavController().navigate(R.id.action_registrationFragment_to_baseFragment)
            }
        }
    }
}