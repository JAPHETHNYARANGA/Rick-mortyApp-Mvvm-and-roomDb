package com.storesoko.rickmortyapp.Network.dataState

//<T> makes the class generic
//sealed class means the class cannot be inherited
sealed class ScreenState<T>(val data :T? = null, val message : String? = null) {

    class Success<T>(data: T) :ScreenState<T>(data)

    class Loading<T>(data: T? = null) :ScreenState<T>(data)

    class Error<T>(message: String?="null",data: T) :ScreenState<T>(data, message)
}