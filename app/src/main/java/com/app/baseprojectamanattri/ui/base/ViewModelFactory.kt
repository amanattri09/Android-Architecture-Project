package com.app.baseprojectamanattri.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.app.baseprojectamanattri.data.repo.Repositary
import com.app.baseprojectamanattri.ui.sample.SampleActivityViewModel

class ViewModelFactory( val repositary: Repositary) :ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(SampleActivityViewModel::class.java)){
            return SampleActivityViewModel(repositary) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}