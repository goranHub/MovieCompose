package com.example.myfirstcompose.repository

import com.example.myfirstcompose.data.RestApi
import com.example.myfirstcompose.data.response.movie.TopMovieResponse
import com.example.myfirstcompose.ui.movie.API_KEY
import io.reactivex.Observable
import javax.inject.Inject

class Repository(val restApi: RestApi){

    fun loadTopMovies(): Observable<TopMovieResponse> {
        return restApi.getTopRated(API_KEY, 1.toString())
    }
}