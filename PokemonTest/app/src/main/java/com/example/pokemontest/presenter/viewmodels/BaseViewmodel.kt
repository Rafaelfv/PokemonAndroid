package com.example.pokemontest.presenter.viewmodels

import androidx.lifecycle.ViewModel
import com.example.pokemontest.PokemonApp

abstract class BaseViewmodel: ViewModel() {

    init {
        inject()
    }

    private fun inject() {
        when (this) {
            is FragmentListViewModel -> PokemonApp.component.inject(this)
        }
    }
}