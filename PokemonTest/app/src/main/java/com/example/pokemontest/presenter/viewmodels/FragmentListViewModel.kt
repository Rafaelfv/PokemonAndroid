package com.example.pokemontest.presenter.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokemontest.domain.ListPokemonUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class FragmentListViewModel: BaseViewmodel() {

    @Inject
    lateinit var listPokemonUseCase: ListPokemonUseCase

    fun getListPokemon(offset: Int) {
        viewModelScope.launch {
            listPokemonUseCase.getListPokemon(offset.toString())
        }
    }

}