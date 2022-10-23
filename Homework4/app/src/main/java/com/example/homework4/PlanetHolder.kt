package com.example.homework4

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.homework4.databinding.ItemPlanetBinding

class PlanetHolder(
    private val binding: ItemPlanetBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun onBind(planet: Planet){
        with(binding){
            tvPlanetName.text = planet.name
            Glide.with(root)
                .load(planet.url)
                .into(ivCover)
        }
    }
}