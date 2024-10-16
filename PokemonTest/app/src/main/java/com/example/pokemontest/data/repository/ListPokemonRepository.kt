package com.example.pokemontest.data.repository

import com.example.pokemontest.data.Pokemon
import com.example.pokemontest.data.PokemonService
import com.example.pokemontest.data.ResponsePokemonDetails
import com.example.pokemontest.utils.toPokemon
import javax.inject.Inject

class ListPokemonRepository @Inject constructor(
    private val apiListPokemonServiceDataSource: ListPokemonServiceDataSource,
    private val pokemonLocalDataSource: PokemonLocalDataSource
) {

    suspend fun getListPokemon(offset: String): List<Pokemon> {
        if (pokemonLocalDataSource.isEmpty()) {
            val pokemonServiceList =
                apiListPokemonServiceDataSource.getResponseListPokemon(offset).body()?.results
            if (!pokemonServiceList.isNullOrEmpty()) {
                pokemonServiceList.forEach { pokemonItemList ->
                    getPokemonDetails(pokemonItemList.name) { pokemonDetail ->
                        pokemonItemList.details = pokemonDetail
                    }
                }
            }
            pokemonLocalDataSource.save(pokemonServiceList)
        }
        return pokemonLocalDataSource.getAllPokemons().map { it.toPokemon() }
    }

    private suspend fun getPokemonDetails(
        name: String,
        detail: (pokemonDetail: ResponsePokemonDetails) -> Unit
    ) {
        val detailRequest = apiListPokemonServiceDataSource.getPokemonDetails(name)
        detailRequest.body()?.let { detail(it) }
    }

    suspend fun getPokemonDetails(id: Int): Pokemon {
        return pokemonLocalDataSource.getPokemonById(id)
    }
}