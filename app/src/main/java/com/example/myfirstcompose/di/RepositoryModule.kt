package com.example.myfirstcompose.di

import com.example.myfirstcompose.data.RestApi
import com.example.myfirstcompose.repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideRepository(restapi: RestApi)  = Repository(restapi)
}