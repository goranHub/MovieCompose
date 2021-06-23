package com.example.myfirstcompose.ui.movie.details

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class DetailsViewModel : ViewModel() {
    val loading = mutableStateOf(false)
}
