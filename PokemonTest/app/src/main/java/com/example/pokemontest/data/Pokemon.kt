package com.example.pokemontest.data


data class Pokemon (
    var id: Int = 0,
    var name: String,
    var height: Int,
    var weight: Int,
    var frontDefault: String?,
    var type: String?
)