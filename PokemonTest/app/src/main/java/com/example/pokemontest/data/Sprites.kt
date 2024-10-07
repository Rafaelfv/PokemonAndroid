package com.example.pokemontest.data

import com.google.gson.annotations.SerializedName

data class Sprites(
    @SerializedName("front_default") var frontDefault: String?
)