package com.app.baseprojectamanattri.presentation.common.base

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

open class BaseViewModel : ViewModel() {

    var compositeDisposable=CompositeDisposable()

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }

    fun Disposable.addToCompositeDisposable() {
        compositeDisposable.add(this)
    }

}