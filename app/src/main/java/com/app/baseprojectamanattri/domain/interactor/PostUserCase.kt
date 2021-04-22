package com.app.baseprojectamanattri.domain.post.interactor

import com.app.baseprojectamanattri.domain.post.models.PostModel
import com.app.baseprojectamanattri.domain.post.repositary.PostRepositary
import javax.inject.Inject

class PostUserCase  @Inject constructor(val repositary: PostRepositary){
    fun getPosts(): List<PostModel>? {
        return repositary.getPosts()
    }


}