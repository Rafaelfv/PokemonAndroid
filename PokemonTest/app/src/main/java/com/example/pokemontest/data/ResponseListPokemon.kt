package com.example.pokemontest.data

import com.google.gson.annotations.SerializedName


data class ResponseListPokemon(
    @SerializedName("count") var count: Int,
    @SerializedName("next") var next: String,
    @SerializedName("previous") var previous: String,
    @SerializedName("results") var results: MutableList<Pokemon>?,
)
