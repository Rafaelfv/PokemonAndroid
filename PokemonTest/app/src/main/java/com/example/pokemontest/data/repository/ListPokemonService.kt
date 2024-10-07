package com.example.pokemontest.data.repository

import com.example.pokemontest.data.ResponseListPokemon
import com.example.pokemontest.injection.ApiPokemon
import retrofit2.Response
import javax.inject.Inject

class ListPokemonService @Inject constructor(private val api: ApiPokemon) {

    suspend fun getResponseListPokemon(offset: String): Response<ResponseListPokemon> {
        return api.getListPokemon(offset = offset)
    }
}