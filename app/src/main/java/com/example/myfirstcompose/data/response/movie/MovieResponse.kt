package com.example.myfirstcompose.data.response.movie

import android.os.Parcelable
import androidx.annotation.Keep
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@Keep
@JsonClass(generateAdapter = true)
data class MovieResponse(
    @Json(name="id")
    val movieID: Int,
    @Json(name="original_title")
    val originalTitle: String,
    val overview: String,
    @Json(name="poster_path")
    val posterPath: String,
    val popularity: String,
    @Json(name="release_date")
    val releaseDate: String,
    @Json(name="title")
    val title: String?
): Parcelable
