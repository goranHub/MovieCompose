package com.example.myfirstcompose.ui.movie.topmovie

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.hilt.navigation.compose.hiltNavGraphViewModel
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.myfirstcompose.Screen
import com.example.myfirstcompose.navigate
import com.example.myfirstcompose.ui.theme.MyFirstComposeTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class TopFragment : Fragment() {

    @Inject
    lateinit var topViewModelFactory: TopViewModelFactory
    private val viewModel: TopViewModel by viewModels { provideFactory(topViewModelFactory) }

    @SuppressLint("CheckResult")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel.navigateTo.observe(viewLifecycleOwner) { navigateToEvent ->
            navigateToEvent.let { navigateTo ->
                navigate(navigateTo, Screen.TopMovie)
            }
        }

        return ComposeView(requireContext()).apply {
            setContent {
                MyFirstComposeTheme {
/*                    TopScreenButtons(
                        onNavigationEvent = {
                            viewModel.navToPopularMovie()
                        }
                    )*/
                    DisplayItems(viewModel) {
                    }
                }
            }
        }
    }
}


@Composable
fun DisplayItems(viewModel: TopViewModel, selectedItem: (Int) -> Unit) {

    val movies = remember { viewModel.movieList }

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
