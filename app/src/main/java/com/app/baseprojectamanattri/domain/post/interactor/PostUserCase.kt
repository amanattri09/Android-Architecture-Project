package com.app.baseprojectamanattri.domain.post.interactor

import com.app.baseprojectamanattri.domain.post.models.PostModel
import com.app.baseprojectamanattri.domain.post.repositary.PostRepositary
import io.reactivex.Single
import javax.inject.Inject

class PostUserCase  @Inject constructor(val repositary: PostRepositary){

    fun getPostsRx(): Single<List<PostModel>> {
        return repositary.getPostsRx()
    }

    fun getPost(postId:String): Single<PostModel> {
        return repositary.getPost(postId)
    }

}