package com.example.pokemontest.data

import com.google.gson.annotations.SerializedName

data class ResponsePokemonDetails(
    @SerializedName("abilities") var abilities: ArrayList<Abilities> = arrayListOf(),
    @SerializedName("sprites") var sprites: Sprites,
    @SerializedName("id") var id: Int = 0,
    @SerializedName("name") var name: String,
    @SerializedName("height") var height: Int,
    @SerializedName("weight") var weight: Int,
    @SerializedName("types") var types: ArrayList<Types> = arrayListOf(),
)