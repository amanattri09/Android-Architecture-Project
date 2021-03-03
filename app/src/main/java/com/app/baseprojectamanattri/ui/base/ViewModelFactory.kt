package com.app.baseprojectamanattri.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.app.baseprojectamanattri.data.repo.RepositaryImp
import com.app.baseprojectamanattri.ui.sample.SampleActivityViewModel

class ViewModelFactory:ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(SampleActivityViewModel::class.java)){
            return SampleActivityViewModel(RepositaryImp()) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}