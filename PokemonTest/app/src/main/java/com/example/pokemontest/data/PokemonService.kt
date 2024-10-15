package com.example.pokemontest.data

import com.google.gson.annotations.SerializedName

data class PokemonService(
    @SerializedName("name") var name: String,
    @SerializedName("url") var url: String?,
    var details: ResponsePokemonDetails? = null
)