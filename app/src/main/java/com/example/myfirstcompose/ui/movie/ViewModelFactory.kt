package com.example.myfirstcompose.ui.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myfirstcompose.repository.Repository
import com.example.myfirstcompose.ui.movie.details.DetailsViewModel
import com.example.myfirstcompose.ui.movie.popular.PopularViewModel
import com.example.myfirstcompose.ui.movie.topmovie.TopViewModel


class ViewModelFactory(
    val repository: Repository,
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PopularViewModel::class.java)) {
            return PopularViewModel(repository) as T
        }
        if (modelClass.isAssignableFrom(TopViewModel::class.java)) {
            return DetailsViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }


}