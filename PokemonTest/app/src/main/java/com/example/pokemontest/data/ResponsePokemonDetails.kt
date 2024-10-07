package com.example.pokemontest.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ResponsePokemonDetails(
    @SerializedName("sprites") var sprites: Sprites,
    @SerializedName("id") var id: Int = 0,
    @SerializedName("name") var name: String,
    @SerializedName("height") var height: Int,
    @SerializedName("weight") var weight: Int,
    @SerializedName("types") var types: ArrayList<Types> = arrayListOf(),
) : Parcelable