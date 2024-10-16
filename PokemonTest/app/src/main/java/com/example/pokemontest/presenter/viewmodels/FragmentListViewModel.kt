package com.example.pokemontest.presenter.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.pokemontest.data.Pokemon
import com.example.pokemontest.data.PokemonService
import com.example.pokemontest.domain.ListPokemonUseCase
import com.example.pokemontest.utils.Status
import com.example.pokemontest.utils.toPokemonList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

class FragmentListViewModel : BaseViewmodel() {

    private val _state = MutableStateFlow(UiState())
    val state: StateFlow<UiState> = _state.asStateFlow()

    @Inject
    lateinit var listPokemonUseCase: ListPokemonUseCase

    fun getListPokemon(offset: Int) {
        viewModelScope.launch {
            _state.update { it.copy(loading = true) }
            val response = listPokemonUseCase.getListPokemon(offset.toString())
            if (response.status == Status.SUCCESS) {
                _state.update { it.copy(loading = false) }
                _state.update { it.copy(pokemonServiceList = response.data ?: emptyList()) }
            }
        }
    }

    data class UiState(val loading: Boolean = false, val pokemonServiceList: List<Pokemon> = emptyList())
}

class FragmentListViewModelFactory:  ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
        return FragmentListViewModel() as T
    }
}