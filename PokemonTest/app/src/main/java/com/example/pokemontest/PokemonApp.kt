package com.example.pokemontest

import android.app.Application
import com.example.pokemontest.injection.ComponentInjector
import com.example.pokemontest.injection.DaggerComponentInjector
import com.example.pokemontest.injection.NetworkModule

class PokemonApp: Application() {

    companion object {
        lateinit var component: ComponentInjector
    }

    override fun onCreate() {
        super.onCreate()
        component = DaggerComponentInjector.builder().networkModule(NetworkModule).build()

    }
}