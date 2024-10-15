package com.example.pokemontest.utils

import com.example.pokemontest.data.Pokemon
import com.example.pokemontest.data.PokemonDb
import com.example.pokemontest.data.PokemonService

fun PokemonService.toPokemonDb() = PokemonDb(
    id = this.details?.id ?:0,
    name = name,
    type = details?.types?.first()?.type?.name ?: "type",
    frontDefault = details?.sprites?.frontDefault ?: "",
    weight = details?.weight?: 0,
    height = details?.height?: 0
)

fun PokemonService.toPokemon() = Pokemon(
    id = this.details?.id ?:0,
    name = name,
    type = details?.types?.first()?.type?.name ?: "type",
    frontDefault = details?.sprites?.frontDefault ?: "",
    weight = details?.weight?: 0,
    height = details?.height?: 0
)

fun PokemonDb.toPokemon() = Pokemon(
    id = id,
    name = name,
    type = type,
    frontDefault = frontDefault,
    weight = weight,
    height = height
)

fun List<PokemonService>.toPokemonList(): List<Pokemon> {
    val list: MutableList<Pokemon> = mutableListOf()
    this.forEach {
        list.add(it.toPokemon())
    }
    return list
}
