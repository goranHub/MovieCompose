package com.example.myfirstcompose.ui.movie.topmovie

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material.rememberScaffoldState
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.myfirstcompose.BaseApplication
import com.example.myfirstcompose.Screen
import com.example.myfirstcompose.navigate
import com.example.myfirstcompose.ui.theme.AppTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class TopFragment : Fragment() {

    //for toggling theme
    @Inject
    lateinit var application: BaseApplication

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

                val loading = viewModel.loading.value
                val movies = viewModel.movieList.value
                val scaffoldState = rememberScaffoldState()

                AppTheme(
                    displayProgressBar = loading,
                    scaffoldState = scaffoldState,
                    darkTheme = application.isDark.value,
                ) {
                    TopScreenButtons(
                        movies,
                        selectedItem  = {  },
                        onNavigationEvent = {viewModel.navToPopularMovie()}
                    )
                }
            }
        }
    }
}


