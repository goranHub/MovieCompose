package com.example.myfirstcompose.ui.movie.popular

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myfirstcompose.ui.util.ButtonColor
import com.example.myfirstcompose.ui.util.ButtonSize
import com.example.myfirstcompose.ui.util.ButtonStyle
import com.example.myfirstcompose.ui.util.MyButton


@Preview
@Composable
fun PopularScreen(onNavigationEvent: () -> Unit, onLoadPopularMovies: () -> Unit) {
    Surface(
        color = MaterialTheme.colors.background,
        modifier = Modifier.fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .size(150.dp)
                .background(Color.LightGray),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.Bottom
        ) {
            Spacer(modifier = Modifier.height(50.dp))

            MyButton(isLoading = false,
                onClick = {
                    onLoadPopularMovies()
                },
                modifier = Modifier.fillMaxWidth(),
                text = "Load Popular Movies",
                buttonColor = ButtonColor.Red,
                isEnable = true,
                buttonStyle = ButtonStyle.Outline,
                buttonSize = ButtonSize.Large
            )

            MyButton(
                isLoading = false,
                onClick = {
                    onNavigationEvent()
                },
                modifier = Modifier.fillMaxWidth(),
                text = "Move To Top Screen",
                buttonColor = ButtonColor.Red,
                isEnable = true,
                buttonStyle = ButtonStyle.Outline,
                buttonSize = ButtonSize.Large
            )
        }
    }
}


