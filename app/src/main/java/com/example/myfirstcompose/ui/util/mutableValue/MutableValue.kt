package com.example.myfirstcompose.ui.util.mutableValue

abstract class MutableValue<T : Any> : Value<T>() {

    abstract override var value: T
}
