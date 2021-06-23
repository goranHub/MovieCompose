package com.example.myfirstcompose

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import java.security.InvalidParameterException

enum class Screen { TopMovie, Popular, Details }

fun Fragment.navigate(to: Screen, from: Screen, bundle: Bundle?) {
    if (to == from) {
        throw InvalidParameterException("Can't navigate to $to")
    }
    val id = when (to) {
        Screen.TopMovie -> R.id.top_fragment
        Screen.Popular -> R.id.popular_fragment
        Screen.Details -> R.id.details_fragment
    }
    findNavController().navigate(id, bundle)
}

