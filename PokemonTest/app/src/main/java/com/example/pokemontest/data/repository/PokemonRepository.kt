package com.example.pokemontest.data.repository

import androidx.room.Query
import com.example.pokemontest.data.PokemonDb

interface PokemonRepository {

    fun insertPokemon(pokemonDb: PokemonDb)

    fun getAllPokemons(): List<PokemonDb>
}