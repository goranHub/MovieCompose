package com.example.myfirstcompose.ui.movie.topmovie

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myfirstcompose.Screen
import com.example.myfirstcompose.data.response.movie.TopMovieResponse
import com.example.myfirstcompose.repository.Repository
import io.reactivex.Observable

class TopViewModel(val repository: Repository) : ViewModel() {

    private val _navigateTo = MutableLiveData<Screen>()
    val navigateTo: LiveData<Screen> = _navigateTo

    fun navToPopularMovie() {
        _navigateTo.value = Screen.Popular
    }

    @SuppressLint("CheckResult")
    fun loadTopMovies(): Observable<TopMovieResponse> {
       return repository.loadTopMovies()
    }


}
