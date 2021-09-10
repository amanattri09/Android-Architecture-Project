package com.app.baseprojectamanattri.presentation.common

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.app.baseprojectamanattri.data.remote.post.entities.Result
import io.reactivex.Single
import io.reactivex.disposables.Disposable

private fun <T> MutableLiveData<Result<T>>.setLoading() = postValue(Result.Loading)
private fun <T> MutableLiveData<Result<T>>.setSuccess(data: T) = postValue(Result.Success(data))
private fun <T> MutableLiveData<Result<T>>.setError(throwable: Throwable, showErrorView: Boolean) = postValue(Result.Error(throwable,showErrorView))



fun <Param> Single<Param>.defaultSubscrition(posts: MutableLiveData<Result<Param>>,showErrorView:Boolean): Disposable {
    return this.doOnSubscribe {
        posts.setLoading()
    }.subscribe({
        posts.setSuccess(it)
    }, {
        posts.setError(it,showErrorView)
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
