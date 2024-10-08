package com.example.pokemontest.presenter.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pokemontest.data.Pokemon
import com.example.pokemontest.databinding.ItemPokemonBinding

class AdapterListPokemon :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var list: MutableList<Pokemon> = mutableListOf()
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

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ItemViewHolder).bind(list[position], context)

        if (position == list.size - 1) {
            onBottomReached?.invoke(true)
        }
    }

    fun updateList(pokemonList: List<Pokemon>?) {
        pokemonList?.let { list.addAll(it) }
        notifyDataSetChanged()
    }

    inner class ItemViewHolder(private val binding: ItemPokemonBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(pokemon: Pokemon, context: Context) {
            Glide.with(context).load(pokemon.details?.sprites?.frontDefault).into(binding.imageView)
            binding.name.text = pokemon.name
            binding.root.setOnClickListener {
                onItemClick?.invoke(list[adapterPosition])
            }
        }
    }
}


