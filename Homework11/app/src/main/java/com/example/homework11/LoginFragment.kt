package com.example.homework11

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.homework11.databinding.LoginFragmentBinding
import com.example.homework11.settings.SharedPrefManager

class LoginFragment: Fragment() {
    private var _binding: LoginFragmentBinding? = null
    private val binding by lazy { _binding!! }
    private var sharedPrefManager: SharedPrefManager? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = LoginFragmentBinding.inflate(layoutInflater)
        sharedPrefManager = SharedPrefManager(binding.root.context)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClickListeners()
    }

    fun<T> Context.showToast(message: T) = Toast.makeText(this, message.toString(), Toast.LENGTH_SHORT).show()

    private fun initClickListeners() {
        with(binding) {
            registration.setOnClickListener {
                findNavController().navigate(R.id.action_loginFragment_to_registrationFragment)
            }
            buttonLogin.setOnClickListener{
                val login = inputLogin.editText?.text.toString()
                val password = inputPassword.editText?.text.toString()
                if (login.length > 64) {
                    context?.showToast("Too long mail")
                }  else if (login.length < 3) {
                    context?.showToast("Too short mail")
                }
                if (login.contains(" ") || password.contains(" ")) {
                    context?.showToast("Invalid character")
                }
                findNavController().navigate(R.id.action_loginFragment_to_baseFragment)
            }
        }
    }

    companion object {
        private const val ARG_TEXT = "ARG_TEXT"
        fun createBundle(message: String) = bundleOf( ARG_TEXT to message)
    }
}