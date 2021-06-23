package com.example.myfirstcompose

import android.app.Application
import androidx.compose.runtime.mutableStateOf
import dagger.hilt.android.HiltAndroidApp

/**
 * @author ll4
 * @date 12/31/2020
 */
@HiltAndroidApp
class BaseApplication : Application(){

    // should be saved in data store
    val isDark = mutableStateOf(false)

    fun toggleLightTheme(){
        isDark.value = !isDark.value
    }

}