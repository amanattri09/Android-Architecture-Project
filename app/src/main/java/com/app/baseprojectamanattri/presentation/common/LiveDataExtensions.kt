package com.app.baseprojectamanattri.presentation.common

import androidx.lifecycle.MutableLiveData
import com.app.baseprojectamanattri.data.remote.post.entities.ApiResponse
import io.reactivex.Single
import io.reactivex.disposables.Disposable

fun <Param> Single<Param>.defaultSubscrition(posts: MutableLiveData<ApiResponse<Param>>): Disposable {
    return this.doOnSubscribe{
        posts.postValue(ApiResponse.loading(null))
    }.subscribe({
        posts.postValue(ApiResponse.success(it))
    },{
        posts.postValue(ApiResponse.error(it.message,null))
    })
}

private fun <T> MutableLiveData<ApiResponse<T>>.setLoading() = postValue(ApiResponse.loading(null))
private fun <T> MutableLiveData<ApiResponse<T>>.setSuccess() = postValue(ApiResponse.loading(null))
private fun <T> MutableLiveData<ApiResponse<T>>.setError() = postValue(ApiResponse.loading(null))
