package com.example.homework4

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.example.homework4.databinding.ItemPlanetBinding

class PlanetAdapter(
    private val requestManager: RequestManager,
    private val list: List<Planet>,
    private val onItemClick: (Planet) -> Unit
) : RecyclerView.Adapter<PlanetHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PlanetHolder = PlanetHolder(
        ItemPlanetBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ), requestManager, onItemClick
    )

    override fun onBindViewHolder(
        holder: PlanetHolder,
        position: Int
    ) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size
}