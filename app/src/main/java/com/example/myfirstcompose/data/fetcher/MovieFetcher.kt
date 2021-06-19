package com.example.myfirstcompose.data.fetcher

import androidx.annotation.WorkerThread
import com.example.myfirstcompose.data.RestApi
import com.example.myfirstcompose.data.response.movie.TopMovieResponse
import com.example.myfirstcompose.ui.util.Resource

interface MovieFetcher  {
  @WorkerThread
  fun fetchMovie(apiKey :String, page:Int, restApi: RestApi) : Resource<TopMovieResponse>
}