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
import com.example.myfirstcompose.repository.Repository
import com.example.myfirstcompose.ui.movie.ViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class PopularFragment : Fragment() {

    @Inject
    lateinit var repository: Repository

    private val viewModel: PopularViewModel by viewModels { ViewModelFactory(repository) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        fun navToTopMovie() {
            navigate(Screen.TopMovie, Screen.Popular, null)
        }

        return ComposeView(requireContext()).apply {
            setContent {
              //  AppTheme {
                    PopularScreen(
                        onNavigationEvent = {
                            navToTopMovie()
                        },
                        {

                        },
                        requireContext()
                    )
                //}
            }
        }
    }
}