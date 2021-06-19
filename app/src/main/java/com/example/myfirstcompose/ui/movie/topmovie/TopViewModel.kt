package com.example.myfirstcompose.ui.movie.topmovie

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.hilt.Assisted
import androidx.lifecycle.*
import com.example.myfirstcompose.Screen
import com.example.myfirstcompose.data.RestApi
import com.example.myfirstcompose.data.response.movie.MovieResponse
import com.example.myfirstcompose.di.Dispatchers
import com.example.myfirstcompose.repository.Repository
import dagger.assisted.AssistedInject
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject


class TopViewModel @AssistedInject constructor(
    val repository: Repository,
    @Dispatchers.IO private val ioDispatcher: CoroutineDispatcher,
    ) : ViewModel() {

    @Inject
    lateinit var restApi: RestApi

    val loading = mutableStateOf(false)


    private val _navigateTo = MutableLiveData<Screen>()
    val navigateTo: LiveData<Screen> = _navigateTo


    fun navToPopularMovie() {
        _navigateTo.value = Screen.Popular
    }

    init {
        loadMovies()
    }

    var movieList : MutableState<List<MovieResponse>> = mutableStateOf(listOf())

    private fun loadMovies() {
        loading.value = true
        // simulate a delay to show loading
        viewModelScope.launch(ioDispatcher) {
            val result = repository.getMovieList().data?.results
            movieList.value = result!!
            loading.value = false
        }
    }
}

