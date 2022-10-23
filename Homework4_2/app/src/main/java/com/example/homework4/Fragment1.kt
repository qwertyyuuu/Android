package com.example.homework4

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.homework4.databinding.Fragment1Binding
import com.google.android.material.snackbar.Snackbar
import java.text.FieldPosition

class Fragment1 : Fragment(R.layout.fragment1) {
    private var _binding: Fragment1Binding? = null
    private val binding get() = _binding!!
    private var adapter: PlanetAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = Fragment1Binding.bind(view)
        adapter = PlanetAdapter(Glide.with(this), PlanetRepository.planets,
            onItemClick = ::PlanetWasClicked)
        binding.rvFragment1.adapter = adapter
    }

    companion object {
        const val FIRST_FRAGMENT_TAG = "FIRST_FRAGMENT_TAG"
        fun getInstance(): Fragment1 = Fragment1()
    }

    private fun PlanetWasClicked(itemPosition: Int) {
        adapter.notifyItemChanged(itemPosition)

    }
}
