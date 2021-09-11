package com.app.baseprojectamanattri.data.remote.post.entities

sealed class Result<out T> {

    object Loading : Result<Nothing>()

    data class Success<out T>(val data: T) : Result<T>()

    data class Error(val throwable: Throwable, val showErrorView: Boolean) : Result<Nothing>()

}
