package com.example.myfirstcompose.ui.movie.topmovie

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.myfirstcompose.Screen
import com.example.myfirstcompose.data.response.movie.TopMovieResponse
import com.example.myfirstcompose.navigate
import com.example.myfirstcompose.repository.Repository
import com.example.myfirstcompose.ui.movie.ViewModelFactory
import com.example.myfirstcompose.ui.theme.MyFirstComposeTheme
import com.example.myfirstcompose.ui.util.mutableValue.MutableValue
import com.example.myfirstcompose.ui.util.mutableValue.Value
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class TopFragment : Fragment() {

    @Inject
    lateinit var repository: Repository
    private val viewModel: TopViewModel by viewModels { ViewModelFactory(repository) }

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

/*        viewModel.loadTopMovies()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { System.out.println("Subscribe") }*/

        val modelRes : Value<TopMovieResponse> = MutableValue(TopMovieResponse(333))


        return ComposeView(requireContext()).apply {
            setContent {
                MyFirstComposeTheme {
                    TopScreen(
                        viewModel.loadTopMovies(), //response from api rxJava
                        onNavigationEvent = {
                            viewModel.navToPopularMovie()
                        },modelRes)
                }
            }
        }
    }
}
