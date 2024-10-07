package com.example.pokemontest.injection

import com.example.pokemontest.data.ResponseListPokemon
import com.example.pokemontest.data.ResponsePokemonDetails
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiPokemon {

    @Headers("Accept: application/json")
    @GET("pokemon")
    suspend fun getListPokemon(
        @Query("limit") limit: String = "25", @Query("offset") offset: String = "25"
    ): Response<ResponseListPokemon>

    @Headers("Accept: application/json")
    @GET("pokemon/{pokemonName}")
    suspend fun getPokemonDetail(
        @Path(value = "pokemonName") name: String
    ): Response<ResponsePokemonDetails>

}