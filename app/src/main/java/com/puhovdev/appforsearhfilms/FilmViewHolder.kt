package com.puhovdev.appforsearhfilms

import androidx.recyclerview.widget.RecyclerView
import com.puhovdev.appforsearhfilms.databinding.FilmItemBinding

class FilmViewHolder(binding: FilmItemBinding) : RecyclerView.ViewHolder(binding.root) {
    private val title = binding.TVTitle
    private val poster = binding.IVPoster
    private val description = binding.TVDescription
    private val ratingDonut = binding.ratingDonut
    private val year = binding.TVYear

    fun bind(film: Film) {
        title.text = film.title
        poster.setImageResource(film.poster)
        description.text = film.description
        ratingDonut.setProgress((film.rating * 10).toInt())
        year.text = film.year.toString()
    }
}