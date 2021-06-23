package com.example.myfirstcompose.data.response.tvShow

import com.google.gson.annotations.SerializedName

data class TvResponse(
    val first_air_date: String,
    val overview: String,
    val popularity: Double,
    @SerializedName("poster_path")
    val posterPath: String
)