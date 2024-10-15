package com.example.pokemontest

import android.app.Application
import androidx.room.Room
import com.example.pokemontest.data.db.AppDatabase
import com.example.pokemontest.injection.ComponentInjector
import com.example.pokemontest.injection.DaggerComponentInjector
import com.example.pokemontest.injection.NetworkModule

class PokemonApp: Application() {

    companion object {
        lateinit var component: ComponentInjector
        lateinit var database: AppDatabase
    }

    override fun onCreate() {
        super.onCreate()
        component = DaggerComponentInjector.builder().networkModule(NetworkModule).build()
        database = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "my_database"
        ).build()
    }
}