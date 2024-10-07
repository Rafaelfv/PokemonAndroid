package com.example.pokemontest.data

import com.example.pokemontest.Type
import com.google.gson.annotations.SerializedName

data class Types(
    @SerializedName("slot") var slot: Int? = null,
    @SerializedName("type") var type: Type
)