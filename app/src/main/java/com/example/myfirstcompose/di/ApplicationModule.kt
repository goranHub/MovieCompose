package com.example.myfirstcompose.di

import com.example.myfirstcompose.data.fetcher.MovieFetcher
import com.example.myfirstcompose.data.fetcher.MovieFetcherImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@Module(includes = arrayOf(ApplicationModule.Bindings::class))
@InstallIn(SingletonComponent::class)
object ApplicationModule {

  @Provides
  @com.example.myfirstcompose.di.Dispatchers.IO
  fun ioDispatcher(): CoroutineDispatcher = Dispatchers.IO

  @Provides
  @com.example.myfirstcompose.di.Dispatchers.Main
  fun uiDispatcher(): CoroutineDispatcher = Dispatchers.Main


  @Module
  @InstallIn(SingletonComponent::class)
  interface Bindings {


    @Binds
    fun bindMovieFetcher(
      impl: MovieFetcherImpl
    ): MovieFetcher
  }
}