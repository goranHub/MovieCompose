package com.example.myfirstcompose.ui.movie.topmovie

import androidx.compose.foundation.Image
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.myfirstcompose.data.response.movie.MovieResponse
import com.example.myfirstcompose.ui.movie.POSTER_URL
import com.example.myfirstcompose.ui.movie.compose.MovieImage

@Composable
fun TopScreenListItems(movie: MovieResponse, selectedItem: (MovieResponse) -> Unit) {
    Card(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth(),
        elevation = 10.dp,
        shape = RoundedCornerShape(corner = CornerSize(10.dp))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp)
                .clickable { selectedItem(movie) },
            verticalAlignment = Alignment.CenterVertically
        ) {
            MovieImage(
                url = "${POSTER_URL}${movie.posterPath}",
                blur = true,
                successContent = { painter, _ ->
                    Image(
                        painter = painter,
                        contentDescription = "",
                        contentScale = ContentScale.FillBounds
                    )
                }
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 15.dp)
            ) {
                Text(text = movie.originalTitle, style = MaterialTheme.typography.h5)
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = movie.overview,
                    style = MaterialTheme.typography.body1,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = movie.releaseDate, style = MaterialTheme.typography.h5)
                    Text(text = movie.popularity, style = MaterialTheme.typography.h5)
                }
            }
        }
    }
}
