package com.example.myfirstcompose.data.fetcher

import androidx.annotation.WorkerThread
import com.example.myfirstcompose.data.RestApi
import com.example.myfirstcompose.data.response.movie.TopMovieResponse
import com.example.myfirstcompose.ui.util.Resource
import timber.log.Timber
import javax.inject.Inject

class MovieFetcherImpl @Inject constructor() : MovieFetcher {
    @WorkerThread
    override suspend fun fetchMovie(
        apiKey: String,
        page: Int,
        restApi: RestApi
    ): Resource<TopMovieResponse> {
        val response = try {
            restApi.getTopRated(apiKey, page.toString())
        } catch (e: Exception) {
            Timber.e(e.localizedMessage)
            return Resource.Error("An unknown error occurred.")
        }
        return Resource.Success(response)
    }
}
