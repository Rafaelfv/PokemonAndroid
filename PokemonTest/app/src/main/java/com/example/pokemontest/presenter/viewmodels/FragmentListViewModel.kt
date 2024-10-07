package com.example.pokemontest.presenter.viewmodels

import androidx.lifecycle.ViewModel
import com.example.pokemontest.domain.ListPokemonUseCase
import javax.inject.Inject

class FragmentListViewModel: ViewModel() {

    @Inject
    lateinit var listPokemonUseCase: ListPokemonUseCase



}