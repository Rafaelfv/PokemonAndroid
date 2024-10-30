package com.example.pokemontest.presenter.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pokemontest.data.Pokemon
import com.example.pokemontest.databinding.ItemPokemonBinding

class AdapterListPokemon :
    ListAdapter<Pokemon, RecyclerView.ViewHolder>(DiffUtilCallback()) {

    private lateinit var context: Context
    var onItemClick: ((Pokemon) -> Unit)? = null
    var onBottomReached: ((Boolean) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding: ItemPokemonBinding = ItemPokemonBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        context = parent.context
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ItemViewHolder).bind(getItem(position), context)

        if (position == currentList.size - 1) {
            onBottomReached?.invoke(true)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    inner class ItemViewHolder(private val binding: ItemPokemonBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(pokemon: Pokemon, context: Context) {
            Glide.with(context).load(pokemon.frontDefault).into(binding.imageView)
            binding.name.text = pokemon.name
            binding.root.setOnClickListener {
                onItemClick?.invoke(getItem(adapterPosition))
            }
        }
    }
}

private class DiffUtilCallback: DiffUtil.ItemCallback<Pokemon>() {
    override fun areItemsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean {
        return oldItem == newItem
    }

}
