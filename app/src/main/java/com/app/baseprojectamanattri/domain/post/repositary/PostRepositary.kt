package com.app.baseprojectamanattri.domain.post.repositary

import com.app.baseprojectamanattri.domain.post.models.PostModel
import io.reactivex.Single

interface PostRepositary {
    fun getPostsRx(): Single<List<PostModel>>
    fun getPost(postId:String): Single<PostModel>
}