package com.example.myfirstcompose.ui.movie.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.example.myfirstcompose.data.response.movie.MovieResponse
import com.example.myfirstcompose.ui.movie.POSTER_URL
import com.example.myfirstcompose.ui.movie.compose.MovieImage

@Composable
fun DetailsScreen(
    onNavigationEvent: () -> Unit,
    movie: MovieResponse
) {
    val scrollState = rememberScrollState()
    Card(
        modifier = Modifier.padding(10.dp),
        elevation = 10.dp,
        shape = RoundedCornerShape(corner = CornerSize(10.dp))
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(scrollState)
                .padding(10.dp),
        ) {
            Column(
                modifier =  Modifier.align(Alignment.CenterHorizontally)
            ) {
                MovieImage(
                    url = "$POSTER_URL${movie.posterPath}",
                    blur = true,
                    successContent = { painter, loadState ->
                        Image(
                            painter = painter,
                            contentDescription = "",
                            contentScale = ContentScale.FillBounds,
                        )
                    }
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = movie.originalTitle,
                style = MaterialTheme.typography.h3
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = movie.overview,
                style = MaterialTheme.typography.h5
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Original release : ${movie.releaseDate}",
                style = MaterialTheme.typography.h5
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "IMDB : ${movie.popularity}",
                style = MaterialTheme.typography.h5
            )

        }
    }
}