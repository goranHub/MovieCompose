package com.example.myfirstcompose.data.response.movie


data class TopMovieResponse (
    val page: Int,
    val results: List<MovieResponse>
)
