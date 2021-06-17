package com.example.myfirstcompose.ui.movie.topmovie

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myfirstcompose.Screen
import com.example.myfirstcompose.ui.movie.Repository

class TopViewModel (private val repository: Repository) : ViewModel() {

    private val _navigateTo = MutableLiveData<Screen>()
    val navigateTo: LiveData<Screen> = _navigateTo

    fun navToPopularMovie() {
       // repository.laodPolpular
        _navigateTo.value = Screen.Popular
    }
}
