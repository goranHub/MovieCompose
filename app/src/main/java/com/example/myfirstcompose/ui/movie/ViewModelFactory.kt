package com.example.myfirstcompose.ui.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myfirstcompose.ui.movie.popular.PopularViewModel
import com.example.myfirstcompose.ui.movie.topmovie.TopViewModel

@Suppress("UNCHECKED_CAST")
class ViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PopularViewModel::class.java)) {
            return PopularViewModel(Repository) as T
        }
        if (modelClass.isAssignableFrom(TopViewModel::class.java)) {
            return TopViewModel(Repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}