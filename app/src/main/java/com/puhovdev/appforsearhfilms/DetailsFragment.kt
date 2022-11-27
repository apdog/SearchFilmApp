package com.puhovdev.appforsearhfilms

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.puhovdev.appforsearhfilms.databinding.FragmentDetailsBinding

class DetailsFragment : Fragment() {

    private lateinit var binding: FragmentDetailsBinding
    private lateinit var film: Film

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding) {
        super.onViewCreated(view, savedInstanceState)

        setFilmsDetails()

        detailsFabFavorites.setOnClickListener {
            if (!film.isInFavorites) {
                detailsFabFavorites.setImageResource(R.drawable.ic_favorite)
                film.isInFavorites = true
            } else {
                detailsFabFavorites.setImageResource(R.drawable.ic_action_favourite)
                film.isInFavorites = false
            }
        }

        detailsFabShare.setOnClickListener {
            val intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.putExtra(
                Intent.EXTRA_TEXT,
                "Привет! Отправляю фильм, который нужно обязательно посмотреть: ${film.title} \n\n ${film.description}"
            )
            intent.type = "text/plain"
            startActivity(Intent.createChooser(intent, "Поделиться с:"))
        }
    }

    private fun setFilmsDetails()= with(binding) {
        film = arguments?.get("film") as Film
        toolbarId.title = film.title
        detailsPoster.setImageResource(film.poster)
        detailsDescription.text = film.description

        detailsFabFavorites.setImageResource(
            if (film.isInFavorites) R.drawable.ic_favorite
            else R.drawable.ic_action_favourite
        )
    }
}