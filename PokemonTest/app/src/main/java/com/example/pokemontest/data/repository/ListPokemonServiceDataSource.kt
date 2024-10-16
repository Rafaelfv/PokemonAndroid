package com.example.pokemontest.data.repository

import com.example.pokemontest.data.ResponseListPokemon
import com.example.pokemontest.data.ResponsePokemonDetails
import com.example.pokemontest.injection.ApiPokemon
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Named

class ListPokemonServiceDataSource @Inject constructor(@Named("ApiPokemon") private val api: ApiPokemon) {

    suspend fun getResponseListPokemon(offset: String): Response<ResponseListPokemon> {
        return api.getListPokemon(offset = offset)
    }

    suspend fun getPokemonDetails(name: String): Response<ResponsePokemonDetails> {
        return api.getPokemonDetail(name)
    }
}