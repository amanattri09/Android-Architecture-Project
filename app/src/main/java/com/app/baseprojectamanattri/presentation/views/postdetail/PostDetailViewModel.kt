package com.app.baseprojectamanattri.presentation.views.postdetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.app.baseprojectamanattri.data.remote.post.entities.Result
import com.app.baseprojectamanattri.domain.post.interactor.PostUserCase
import com.app.baseprojectamanattri.domain.post.models.PostModel
import com.app.baseprojectamanattri.presentation.common.base.BaseViewModel
import com.app.baseprojectamanattri.presentation.common.defaultSubscrition
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

@HiltViewModel
class PostDetailViewModel @Inject constructor(val postUserCase: PostUserCase) : BaseViewModel(){

    private var postMutableLiveData= MutableLiveData<Result<PostModel>>()

    fun getPostModelLiveData():LiveData<Result<PostModel>>{
        return postMutableLiveData
    }

    fun getPostDetail(postId: String) {
        postUserCase.getPost(postId).observeOn(AndroidSchedulers.mainThread()).defaultSubscrition(postMutableLiveData,false).addToCompositeDisposable()
    }
}