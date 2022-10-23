package com.example.homework4

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.example.homework4.databinding.ItemPlanetBinding

class PlanetHolder(
    private val binding: ItemPlanetBinding, private val requestManager: RequestManager,
    private val onItemClick: (Planet) -> Unit
) : RecyclerView.ViewHolder(binding.root) {
    fun onBind(planet: Planet){
        with(binding){
            tvPlanetName.text = planet.name
            root.setOnClickListener {
                onItemClick(planet)
            }
            requestManager
                .load(planet.url)
                .into(ivCover)
        }
    }
}
