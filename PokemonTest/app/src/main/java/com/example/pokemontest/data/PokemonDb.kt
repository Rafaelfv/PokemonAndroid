package com.example.pokemontest.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.pokemontest.utils.Constants.Companion.POKEMON_TABLE

@Entity(tableName = POKEMON_TABLE)
class PokemonDb (
    @PrimaryKey val id: Int,
    val name: String,
    val height: Int,
    val weight: Int,
    val frontDefault: String?,
    val type: String?
    )