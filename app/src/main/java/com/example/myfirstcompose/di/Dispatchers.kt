package com.example.myfirstcompose.di

import javax.inject.Qualifier


annotation class Dispatchers {

  @Qualifier
  @MustBeDocumented
  @Retention(AnnotationRetention.BINARY)
  annotation class Main

  @Qualifier
  @MustBeDocumented
  @Retention(AnnotationRetention.BINARY)
  annotation class IO
}

