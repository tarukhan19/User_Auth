package com.demo.authentication.core.domain.utils

sealed class Resource<out T> {
    data class Success<T>(val data : T) : Resource<T>()
    data class Error(val message : String) : Resource<Nothing>()
    class Loading() : Resource<Nothing>()
}