package com.example.myfirstcompose.ui.movie.topmovie

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.myfirstcompose.data.response.movie.MovieResponse
import com.example.myfirstcompose.ui.util.ui.MyIcon
import com.example.myfirstcompose.ui.util.ui.ButtonColor
import com.example.myfirstcompose.ui.util.ui.ButtonSize
import com.example.myfirstcompose.ui.util.ui.ButtonStyle
import com.example.myfirstcompose.ui.util.ui.MyButton


@Composable
fun TopScreen(
    movies: List<MovieResponse>,
    selectedItem: (MovieResponse) -> Unit,
    onNavigationEvent: () -> Unit,
    onBackClick: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Top Movies") },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        MyIcon(Icons.Rounded.ArrowBack)
                    }
                }
            )
        }
    ) {
        Column(
            modifier = Modifier
                .background(Color.LightGray)
                .fillMaxSize(),
            horizontalAlignment = Alignment.Start
        ) {

            Spacer(modifier = Modifier.height(10.dp))

            Row() {
                Button(
                    onClick = {
                        onNavigationEvent()
                    }
                ) {
                    Text("Move To Popular Screen")
                }

                Spacer(modifier = Modifier.weight(0.5f))

                MyButton(
                    isLoading = false,
                    onClick = {
                        //onLoadTopMovies()
                    },
                    modifier = Modifier.fillMaxWidth(),
                    text = "Load Top Movies",
                    buttonColor = ButtonColor.Black,
                    isEnable = true,
                    buttonStyle = ButtonStyle.Outline,
                    buttonSize = ButtonSize.Large
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            LazyColumn(
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
            ) {
                items(
                    items = movies,
                    itemContent = {
                        TopScreenListItems(movie = it, selectedItem)
                    }
                )
            }
        }
    }
}



