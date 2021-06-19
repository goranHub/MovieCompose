package com.example.myfirstcompose.ui.movie.compose

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.myfirstcompose.data.response.movie.MovieResponse

@Composable
fun MovieListItem(movieResponse: MovieResponse, selectedItem: (MovieResponse) -> Unit) {
    Card(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth(),
        elevation = 10.dp,
        shape = RoundedCornerShape(corner = CornerSize(10.dp))
    ) {
        Row(
            modifier = Modifier
                .padding(5.dp)
                .fillMaxWidth()
                .clickable { selectedItem(movieResponse) },
            verticalAlignment = Alignment.CenterVertically
        ) {
            MovieImage(movieResponse = movieResponse)
            Column {
                Text(text = movieResponse.originalTitle, style = MaterialTheme.typography.h5)
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = movieResponse.overview,
                    style = MaterialTheme.typography.body1,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = movieResponse.releaseDate, style = MaterialTheme.typography.h5)
                    Text(text = movieResponse.popularity, style = MaterialTheme.typography.h5)
                }

            }

        }

    }
}