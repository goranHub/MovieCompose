package com.example.myfirstcompose.ui.movie.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.myfirstcompose.Screen
import com.example.myfirstcompose.data.response.movie.MovieResponse
import com.example.myfirstcompose.navigate
import com.example.myfirstcompose.repository.Repository
import com.example.myfirstcompose.ui.movie.ViewModelFactory
import com.example.myfirstcompose.ui.theme.AppTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class DetailsFragment : Fragment() {

    @Inject
    lateinit var repository: Repository
    private val viewModel: DetailsViewModel by viewModels { ViewModelFactory(repository) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel.navigateTo.observe(viewLifecycleOwner) { navigateToEvent ->
            navigateToEvent.let { navigateTo ->
                navigate(navigateTo, Screen.Popular)
            }
        }

        val res = MovieResponse(2,"","","","","","")

        return ComposeView(requireContext()).apply {
            setContent {
               // AppTheme {
                    DetailsScreen(
                        onNavigationEvent = {
                            viewModel.navToTopMovie()
                        },
                        res
                    )
               // }
            }
        }
    }
}














