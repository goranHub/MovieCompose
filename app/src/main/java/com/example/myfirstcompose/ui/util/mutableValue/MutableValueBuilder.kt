package com.example.myfirstcompose.ui.util.mutableValue

import kotlin.properties.Delegates

@Suppress("FunctionName") // Factory function
fun <T : Any> MutableValue(initialValue: T): MutableValue<T> = MutableValueImpl(initialValue)

private class MutableValueImpl<T : Any>(initialValue: T) : MutableValue<T>() {
    private var observers = emptySet<ValueObserver<T>>()

    override var value: T by Delegates.observable(initialValue) { _, _, value ->
        observers.forEach { it(value) }
    }

    override fun subscribe(observer: ValueObserver<T>) {
        observers = observers + observer
        observer(value)
    }

    override fun unsubscribe(observer: ValueObserver<T>) {
        observers = observers - observer
    }
}
