package com.example.myfirstcompose.ui.movie.topmovie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.assisted.AssistedFactory

@AssistedFactory
interface TopViewModelFactory{

fun create(): TopViewModel
}

fun provideFactory(assistedFactory:TopViewModelFactory): ViewModelProvider.Factory =
    object : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return assistedFactory.create() as T
        }
    }

