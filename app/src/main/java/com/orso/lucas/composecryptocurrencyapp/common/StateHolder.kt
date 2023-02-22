package com.orso.lucas.composecryptocurrencyapp.common

sealed class StateHolder<T> {

    class Success<T>(val data: T) : StateHolder<T>()

    class Error<T>(val th: Throwable) : StateHolder<T>()

    class Loading<T> : StateHolder<T>()

}