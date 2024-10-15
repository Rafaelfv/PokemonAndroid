package com.example.pokemontest.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.pokemontest.data.PokemonDb

@Database(entities = [PokemonDb::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun pokemonDao(): PokemonDao
}