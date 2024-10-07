package com.example.pokemontest.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Sprites(
    @SerializedName("front_default") var frontDefault: String?
) : Parcelable