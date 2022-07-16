package com.cite.newscoopup.WeatherPojo

import com.cite.newscoopup.Stings
import com.google.gson.annotations.SerializedName

data class Sys(
        @SerializedName("type") val type:Int,
        @SerializedName("id") val id:Int,
        @SerializedName("country") val country:Stings,
        @SerializedName("sunrise") val sunrise:Int,
        @SerializedName("sunset") val sunset:Int,
)
