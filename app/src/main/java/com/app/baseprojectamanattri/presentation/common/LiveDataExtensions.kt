package com.app.baseprojectamanattri.presentation.common

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.app.baseprojectamanattri.data.remote.post.entities.Result
import com.app.baseprojectamanattri.network.ErrorCodes
import com.app.baseprojectamanattri.network.NetworkError
import io.reactivex.Single
import io.reactivex.disposables.Disposable
import retrofit2.HttpException

private fun <T> MutableLiveData<Result<T>>.setLoading() = postValue(Result.Loading)
private fun <T> MutableLiveData<Result<T>>.setSuccess(data: T) = postValue(Result.Success(data))
private fun <T> MutableLiveData<Result<T>>.setError(throwable: Throwable, showErrorView: Boolean) = postValue(Result.Error(throwable,showErrorView))



fun <Param> Single<Param>.defaultSubscrition(liveData: MutableLiveData<Result<Param>>, showErrorView:Boolean): Disposable {
    return this.doOnSubscribe {
        liveData.setLoading()
    }.subscribe({
        liveData.setSuccess(it)
    }, {
        var networkError = parseException(it)
        if (networkError != null)
            liveData.setError(networkError, showErrorView)
        else
            liveData.setError(it, showErrorView)
        liveData.setError(it,showErrorView)
    })
}

fun <T> LiveData<Result<T>>.customObserver(
    owner: LifecycleOwner,
    onLoading: (Boolean) -> Unit,
    onSuccess: ((data:T) -> Unit)?,
    onError: ((throwable:Throwable,showError:Boolean) -> Unit)?
) {
    this.observe(owner, {
        when (it) {
            is Result.Loading -> {
                onLoading.invoke(true)
            }
            is Result.Success<T> -> {
                onLoading.invoke(false)
                onSuccess?.invoke(it.data)
            }
            is Result.Error -> {
                onLoading.invoke(false)
                onError?.invoke(it.throwable,it.showErrorView)
            }
        }
    })
}

fun parseException(it: Throwable?): NetworkError {
    return when (it) {
        is HttpException -> {
            val exception: HttpException = it as HttpException
            var networkError = NetworkError(exception.code(), exception.message())
            return networkError
        }
        else -> {
            var networkError = NetworkError(ErrorCodes.OTHER_ERROR, it?.message)
            return networkError
        }
    }
}
