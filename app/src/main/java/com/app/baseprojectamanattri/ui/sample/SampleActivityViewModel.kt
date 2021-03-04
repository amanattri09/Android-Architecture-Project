package com.app.baseprojectamanattri.ui.sample

import androidx.lifecycle.MutableLiveData
import com.app.baseprojectamanattri.data.models.ApiResponse
import com.app.baseprojectamanattri.data.repo.RepositaryImp
import com.app.baseprojectamanattri.domain.models.Post
import com.app.baseprojectamanattri.ui.base.BaseViewModel

class SampleActivityViewModel(private val repositary: RepositaryImp) : BaseViewModel() {

    private val posts = MutableLiveData<ApiResponse<List<Post>>>()

    fun fetchPost() {
        posts.postValue(ApiResponse.loading(null))
        repositary.getPosts()
    }


}