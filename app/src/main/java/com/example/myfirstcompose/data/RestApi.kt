package com.example.myfirstcompose.data

import com.example.myfirstcompose.data.response.movie.TopMovieResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface RestApi {

    @GET("movie/top_rated")
    fun getTopRated(
        @Query("api_key") apiKey: String?,
        @Query("page") page: String
    ): TopMovieResponse

}