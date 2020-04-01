package com.example.retrofitinterceptor.webservicecommunication

sealed class Result<out T : Any?>() {
   class Success<out T : Any?>(val data: T) : Result<T>()

    class Error(val exception: Throwable) : Result<Nothing>()
}