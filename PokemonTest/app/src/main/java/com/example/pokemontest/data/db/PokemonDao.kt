package com.example.pokemontest.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.pokemontest.data.PokemonDb

@Dao
interface PokemonDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPokemon(pokemonDb: PokemonDb)

    @Query("SELECT * FROM pokemons")
    fun getAllPokemons(): List<PokemonDb>

}