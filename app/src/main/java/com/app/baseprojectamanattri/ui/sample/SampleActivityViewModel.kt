package com.app.baseprojectamanattri.ui.sample

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.app.baseprojectamanattri.data.models.ApiResponse
import com.app.baseprojectamanattri.data.repo.Repositary
import com.app.baseprojectamanattri.domain.models.Post
import com.app.baseprojectamanattri.ui.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SampleActivityViewModel(private val repositary: Repositary) : BaseViewModel() {

    private lateinit var postsArray: List<Post>
    public val posts = MutableLiveData<ApiResponse<List<Post>>>()
        get() = field

    fun fetchPost() {
        posts.postValue(ApiResponse.loading(null))
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                postsArray = repositary.getPosts()
            }
            if(postsArray!=null){
                posts.postValue(ApiResponse.success(postsArray))
            }else{
                posts.postValue(ApiResponse.error("",null))
            }
        }

    }


}