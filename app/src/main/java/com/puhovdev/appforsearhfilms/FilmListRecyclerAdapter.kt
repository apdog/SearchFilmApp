package com.puhovdev.appforsearhfilms

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.DiffUtil.DiffResult
import androidx.recyclerview.widget.RecyclerView
import com.puhovdev.appforsearhfilms.databinding.FilmItemBinding

class FilmListRecyclerAdapter(private val clickListener: OnItemClickListener) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var items = mutableListOf<Film>()
    private lateinit var diffResult: DiffResult

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return FilmViewHolder(
            FilmItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is FilmViewHolder -> {
                holder.bind(items[position])
                holder.itemView.setOnClickListener {
                    if (position < items.size ){
                        clickListener.click(items[position])
                    } else clickListener.click(items[items.size - position])
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }


    fun addItems(list: List<Film>) {
        diffResult = DiffUtil.calculateDiff(FilmDiffCallback(items, list))
        diffResult.dispatchUpdatesTo(this)
        items = list as MutableList<Film>

    }

    interface OnItemClickListener {
        fun click(film: Film)
    }
}