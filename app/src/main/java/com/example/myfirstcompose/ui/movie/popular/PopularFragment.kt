package com.example.myfirstcompose.ui.movie.popular

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.myfirstcompose.Screen
import com.example.myfirstcompose.navigate
import com.example.myfirstcompose.ui.movie.ViewModelFactory
import com.example.myfirstcompose.ui.theme.MyFirstComposeTheme

class PopularFragment : Fragment() {
    private val viewModel: PopularViewModel by viewModels { ViewModelFactory() }

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

        return ComposeView(requireContext()).apply {
            setContent {
                MyFirstComposeTheme {
                    PopularScreen(
                        onNavigationEvent = {
                            viewModel.navToTopMovie()
                        }
                    )
                }
            }
        }
    }
}