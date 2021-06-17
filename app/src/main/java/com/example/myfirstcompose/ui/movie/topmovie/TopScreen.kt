package com.example.myfirstcompose.ui.movie.topmovie

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rxjava2.subscribeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.myfirstcompose.data.response.movie.TopMovieResponse
import com.example.myfirstcompose.ui.util.*
import com.example.myfirstcompose.ui.util.mutableValue.Value
import com.example.myfirstcompose.ui.util.mutableValue.subscribeAsState
import io.reactivex.Observable


@SuppressLint("CheckResult")
@Composable
fun TopScreen(
    response: Observable<TopMovieResponse>,
    onNavigationEvent: () -> Unit,
    model: Value<TopMovieResponse>
) {
    Surface(
        color = MaterialTheme.colors.background,
        modifier = Modifier.fillMaxSize()
    ) {
              Row(
                  modifier = Modifier.background(Color.LightGray),
                  horizontalArrangement = Arrangement.Center,
                  verticalAlignment = Alignment.Bottom
              ) {
                  Spacer(modifier = Modifier.height(50.dp))

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
              }

        Row(
            modifier = Modifier.background(Color.LightGray),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.Bottom
        ) {
/*

            //try rx NetworkOnMainThreadException
            val res = response.subscribeAsState(model.value)
            Text("Value is ${res.value.page}")

*/

          //mutableValue
            val model by model.subscribeAsState()
            Text("Value is ${model.page}")

        }
    }
}



