package com.example.pokemontest.domain

import com.example.pokemontest.data.Pokemon
import com.example.pokemontest.data.ResponsePokemonDetails
import com.example.pokemontest.data.repository.ListPokemonRepository
import com.example.pokemontest.utils.Fault
import com.example.pokemontest.utils.NewResource
import javax.inject.Inject

class ListPokemonUseCase @Inject constructor(private val repository: ListPokemonRepository) {

    suspend fun getListPokemon(offset: String): NewResource<MutableList<Pokemon>?> {
        return try {
            val response = repository.getListPokemon(offset)
            if (!response.isNullOrEmpty()) {
                response.forEach { pokemonItemList ->
                    getPokemonDetails(pokemonItemList.name) { pokemonDetail ->
                        pokemonItemList.details = pokemonDetail
                    }
                }
                NewResource.success(response)
            } else {
                NewResource.error(
                    Fault(0, message = "message"),
                    null
                ) // todo create sealed class to setup error messages
            }
        } catch (error: Exception) {
            val fault = Fault(1, message = "message")
            NewResource.error(fault, null)
        } finally {
            NewResource.finish(null)
        }
    }

    private suspend fun getPokemonDetails(
        name: String,
        detail: (pokemonDetail: ResponsePokemonDetails) -> Unit
    ) {
        val detailRequest = repository.getPokemonDetails(name)
        if (detailRequest != null){
            detail(detailRequest)
        }
    }

}