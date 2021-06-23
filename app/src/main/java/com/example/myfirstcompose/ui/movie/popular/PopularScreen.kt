package com.example.myfirstcompose.ui.movie.popular

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.myfirstcompose.ui.util.ui.ButtonColor
import com.example.myfirstcompose.ui.util.ui.ButtonSize
import com.example.myfirstcompose.ui.util.ui.ButtonStyle
import com.example.myfirstcompose.ui.util.ui.MyButton

@Composable
fun PopularScreen(
    onNavigationEvent: () -> Unit,
    onLoadPopularMovies: () -> Unit,
    context: Context
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
                text = "Move To Top Screen",
                buttonColor = ButtonColor.Black,
                isEnable = true,
                buttonStyle = ButtonStyle.Outline,
                buttonSize = ButtonSize.Large
            )

            Spacer(modifier = Modifier.weight(1f))

            MyButton(
                isLoading = false,
                onClick = {
                    onLoadPopularMovies()
                },
                modifier = Modifier.fillMaxWidth(),
                text = "Load Popular Movies",
                buttonColor = ButtonColor.Black,
                isEnable = true,
                buttonStyle = ButtonStyle.Outline,
                buttonSize = ButtonSize.Large
            )

        }

        LazyColumnDemo2 {
            Toast.makeText(context, it, Toast.LENGTH_LONG).show()
        }

    }
}


@Composable
fun LazyColumnDemo2(selectedItem: (String) -> (Unit)) {
    LazyColumn {
        items(15) {
            Text(
                "User Name $it",
                style = MaterialTheme.typography.h3,
                modifier = Modifier
                    .padding(10.dp)
                    .clickable { selectedItem("$it Selected") }
            )
            Divider(color = Color.Black, thickness = 5.dp)
        }
    }
}
