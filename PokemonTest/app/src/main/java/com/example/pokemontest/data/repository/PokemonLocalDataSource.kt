package com.example.pokemontest.data.repository

import com.example.pokemontest.data.Pokemon
import com.example.pokemontest.data.PokemonDb
import com.example.pokemontest.data.PokemonService
import com.example.pokemontest.data.db.PokemonDao
import com.example.pokemontest.utils.toPokemon
import com.example.pokemontest.utils.toPokemonDb
import javax.inject.Inject

class PokemonLocalDataSource@Inject constructor(private val pokemonDao: PokemonDao): PokemonRepository {

    override fun insertPokemon(pokemonDb: PokemonDb) {
        pokemonDao.insertPokemon(pokemonDb)
    }

    override fun getAllPokemons(): List<PokemonDb> = pokemonDao.getAllPokemons()

    fun getPokemonById(id: Int): Pokemon {
        return pokemonDao.getPokemonById(id).toPokemon()
    }

    fun save(pokemonServiceList: MutableList<PokemonService>?) {
        pokemonServiceList?.forEach { pokemonService ->
            pokemonDao.insertPokemon(pokemonService.toPokemonDb())
        }
    }

    fun isEmpty(): Boolean = pokemonDao.getAllPokemons().isNullOrEmpty()

}