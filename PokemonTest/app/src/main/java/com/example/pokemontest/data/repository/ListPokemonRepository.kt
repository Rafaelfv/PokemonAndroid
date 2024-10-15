package com.example.pokemontest.data.repository

import com.example.pokemontest.data.PokemonService
import com.example.pokemontest.data.ResponsePokemonDetails
import javax.inject.Inject

class ListPokemonRepository @Inject constructor(private val apiListPokemonService: ListPokemonService) {

    suspend fun getListPokemon(offset: String): MutableList<PokemonService>? {
        val response = apiListPokemonService.getResponseListPokemon(offset)
        val list = response.body()?.results
        return list
    }

    suspend fun getPokemonDetails(name: String): ResponsePokemonDetails? {
        return apiListPokemonService.getPokemonDetails(name).body()
    }
}