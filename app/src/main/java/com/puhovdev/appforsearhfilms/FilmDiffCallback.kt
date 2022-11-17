package com.puhovdev.appforsearhfilms

import androidx.recyclerview.widget.DiffUtil

class FilmDiffCallback(
    private val oldList: List<Film>,
    private val newList: List<Film>
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].poster == newList[newItemPosition].poster &&
                oldList[oldItemPosition].year == newList[newItemPosition].year &&
                oldList[oldItemPosition].title == newList[newItemPosition].title &&
                oldList[oldItemPosition].description == newList[newItemPosition].description &&
                oldList[oldItemPosition].id == newList[newItemPosition].id
    }
}