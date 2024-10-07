package com.example.pokemontest.data.repository

import com.example.pokemontest.data.Pokemon
import javax.inject.Inject

class ListPokemonRepository @Inject constructor(private val apiListPokemonService: ListPokemonService) {

    suspend fun getListPokemon(offset: String): MutableList<Pokemon>? {
        val response = apiListPokemonService.getResponseListPokemon(offset)
        val list = response.body()?.results
        return list
    }

}