package com.example.myfirstcompose.data.fetcher

import androidx.annotation.WorkerThread
import com.example.myfirstcompose.data.RestApi
import com.example.myfirstcompose.data.response.movie.TopMovieResponse
import com.example.myfirstcompose.ui.util.Resource
import javax.inject.Inject

class MovieFetcherImpl @Inject constructor() : MovieFetcher {
    @WorkerThread
    override fun fetchMovie(
        apiKey: String,
        page: Int,
        restApi: RestApi
    ): Resource<TopMovieResponse> {
        val response = try {
            restApi.getTopRated(apiKey, page.toString())
        } catch (e: Exception) {
            return Resource.Error("An unknown error occured.")
        }
        return Resource.Success(response)
    }
}
