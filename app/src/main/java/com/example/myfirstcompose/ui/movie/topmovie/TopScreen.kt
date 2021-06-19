package com.example.myfirstcompose.ui.movie.topmovie

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.myfirstcompose.data.response.movie.MovieResponse
import com.example.myfirstcompose.ui.util.ButtonColor
import com.example.myfirstcompose.ui.util.ButtonSize
import com.example.myfirstcompose.ui.util.ButtonStyle
import com.example.myfirstcompose.ui.util.MyButton


@Composable
fun TopScreenButtons(
    onNavigationEvent: () -> Unit
) {
    Column(
        modifier = Modifier
            .background(Color.LightGray)
            .fillMaxSize(),
        horizontalAlignment = Alignment.Start
    ) {

        Spacer(modifier = Modifier.height(10.dp))

        Row() {

            MyButton(
                isLoading = false,
                onClick = {
                    onNavigationEvent()
                },
                modifier = Modifier.fillMaxWidth(),
                text = "Move To Popular Screen",
                buttonColor = ButtonColor.Red,
                isEnable = true,
                buttonStyle = ButtonStyle.Outline,
                buttonSize = ButtonSize.Large
            )

            Spacer(modifier = Modifier.weight(1f))

            MyButton(
                isLoading = false,
                onClick = {
                    //onLoadTopMovies()
                },
                modifier = Modifier.fillMaxWidth(),
                text = "Load Top Movies",
                buttonColor = ButtonColor.Red,
                isEnable = true,
                buttonStyle = ButtonStyle.Outline,
                buttonSize = ButtonSize.Large
            )
        }
    }
}



