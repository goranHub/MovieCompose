package com.example.myfirstcompose.ui.movie.popular

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Preview
@Composable
fun PopularScreen(onNavigationEvent: () -> Unit) {
    Surface(
        color = MaterialTheme.colors.background,
        modifier = Modifier.fillMaxSize()
    ) {
        Column {
            Spacer(modifier = Modifier.height(20.dp))

            TextButton(
                onClick = {
                    onNavigationEvent()
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "navigate to Popular")
            }
        }
    }
}