package com.example.pokemontest.presenter.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.pokemontest.data.Pokemon
import com.example.pokemontest.domain.ListPokemonUseCase
import com.example.pokemontest.utils.Status
import kotlinx.coroutines.launch
import javax.inject.Inject

class FragmentListViewModel : BaseViewmodel() {

    private val _currentList = MutableLiveData<List<Pokemon>>()
    val currentList: LiveData<List<Pokemon>> = _currentList

    @Inject
    lateinit var listPokemonUseCase: ListPokemonUseCase

    fun getListPokemon(offset: Int) {
        viewModelScope.launch {
            val response = listPokemonUseCase.getListPokemon(offset.toString())
            if (response.status == Status.SUCCESS) {
                _currentList.value = (response.data)
            }
        }
    }

}