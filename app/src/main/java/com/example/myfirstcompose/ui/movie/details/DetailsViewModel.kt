package com.example.myfirstcompose.ui.movie.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myfirstcompose.Screen
import com.example.myfirstcompose.repository.Repository

class DetailsViewModel (val repository: Repository) : ViewModel() {

    private val _navigateTo = MutableLiveData<Screen>()
    val navigateTo: LiveData<Screen> = _navigateTo

    fun navToTopMovie() {
        //repository.loadTopMovie
        _navigateTo.value = Screen.TopMovie
    }

    fun navToPopularMovie() {
        _navigateTo.value = Screen.Popular
    }



}
