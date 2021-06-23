package com.example.myfirstcompose.repository

import com.example.myfirstcompose.data.RestApi
import com.example.myfirstcompose.data.fetcher.MovieFetcher
import com.example.myfirstcompose.data.response.movie.TopMovieResponse
import com.example.myfirstcompose.ui.movie.API_KEY
import com.example.myfirstcompose.ui.util.Resource

class Repository(val restApi: RestApi, private val movieFetcher: MovieFetcher){

    suspend fun getMovieList(): Resource<TopMovieResponse> {
        return try {
            movieFetcher.fetchMovie(API_KEY, 1, restApi)
        } catch (e: Exception) {
            return Resource.Error("An unknown error occurred.")
        }
    }
}