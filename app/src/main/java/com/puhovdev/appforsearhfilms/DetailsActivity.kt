package com.puhovdev.appforsearhfilms

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.puhovdev.appforsearhfilms.databinding.ActivityDetailsBinding
import com.puhovdev.appforsearhfilms.databinding.ActivityMainBinding
import com.puhovdev.appforsearhfilms.databinding.FilmItemBinding

class DetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setFilmsDetails()

    }

    private fun setFilmsDetails()= with(binding) {
        val film = intent.extras?.get("film") as Film
        toolbarId.title = film.title
//Устанавливаем картинку
        detailsPoster.setImageResource(film.poster)
//Устанавливаем описание
        detailsDescription.text = film.description
    }
}