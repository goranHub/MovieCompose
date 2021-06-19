package com.example.myfirstcompose.ui.movie.topmovie

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myfirstcompose.Screen
import com.example.myfirstcompose.data.RestApi
import com.example.myfirstcompose.data.fetcher.MovieFetcher
import com.example.myfirstcompose.data.response.movie.MovieResponse
import com.example.myfirstcompose.di.Dispatchers
import com.example.myfirstcompose.repository.Repository
import com.example.myfirstcompose.ui.movie.API_KEY
import com.example.myfirstcompose.ui.util.Resource
import dagger.assisted.AssistedInject
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import javax.inject.Inject

class TopViewModel @AssistedInject constructor(
    val repository: Repository,
    @Dispatchers.IO private val ioDispatcher: CoroutineDispatcher,
    private val movieFetcher: MovieFetcher
) : ViewModel() {

    @Inject
    lateinit var restApi: RestApi

    private val _navigateTo = MutableLiveData<Screen>()
    val navigateTo: LiveData<Screen> = _navigateTo

    var movieList = mutableStateOf<List<MovieResponse>>(listOf())

    fun navToPopularMovie() {
        _navigateTo.value = Screen.Popular
    }


    fun loadMovies() {
        viewModelScope.launch(ioDispatcher) {

            val result = movieFetcher.fetchMovie(API_KEY, 1, restApi)

            when (result) {
                is Resource.Success -> {
                    movieList.value = result.data?.results ?: return@launch
                }
                is Resource.Error -> {

                }
                is Resource.Loading -> {

                }
            }
        }
    }

}

