package com.example.myfirstcompose.ui.movie.details

import android.content.Context
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.myfirstcompose.data.response.movie.MovieResponse

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
                .padding(10.dp)
        ) {
            Image(
               // painter = painterResource(id = movie.posterPath.toInt()),
               painter = painterResource(id = movie.posterPathFlash),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(4.dp)),
                contentScale = ContentScale.Fit
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
            //    text = movie.originalTitle,
                text ="1",
                style = MaterialTheme.typography.h3
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
             //   text = movie.overview,
                text ="2",
                style = MaterialTheme.typography.h5
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
            //    text = "Original release : ${movie.releaseDate}",
                text ="3",
                style = MaterialTheme.typography.h5
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
            //    text = "IMDB : ${movie.popularity}",
                text ="4",
                style = MaterialTheme.typography.h5
            )

        }
    }
}