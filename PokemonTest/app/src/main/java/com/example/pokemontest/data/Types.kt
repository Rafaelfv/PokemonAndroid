package com.example.pokemontest.data

import android.os.Parcelable
import com.example.pokemontest.Type
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Types(
    @SerializedName("slot") var slot: Int? = null,
    @SerializedName("type") var type: Type
): Parcelable