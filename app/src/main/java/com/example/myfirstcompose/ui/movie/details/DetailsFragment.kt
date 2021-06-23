package com.example.myfirstcompose.ui.movie.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material.rememberScaffoldState
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.myfirstcompose.BaseApplication
import com.example.myfirstcompose.data.response.movie.MovieResponse
import com.example.myfirstcompose.ui.theme.AppTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class DetailsFragment : Fragment() {

    @Inject
    lateinit var application: BaseApplication

    private val viewModel: DetailsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val movie = arguments?.get("MOVIE") as MovieResponse

        return ComposeView(requireContext()).apply {
            setContent {
                val loading = viewModel.loading.value
                val scaffoldState = rememberScaffoldState()

                AppTheme(
                    displayProgressBar = loading,
                    scaffoldState = scaffoldState,
                    darkTheme = application.isDark.value,
                ) {
                    DetailsScreen(
                        onNavigationEvent = {},
                        movie
                    )
                }
            }
        }
    }
}














