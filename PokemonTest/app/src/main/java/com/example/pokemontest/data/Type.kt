package com.example.pokemontest.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Type (
    @SerializedName("name" ) var name : String,
    @SerializedName("url"  ) var url  : String
): Parcelable