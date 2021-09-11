package com.app.baseprojectamanattri.data.remote.post.mapper

import com.app.baseprojectamanattri.data.remote.post.entities.PostEntity
import com.app.baseprojectamanattri.domain.post.models.PostModel

object PostMapper {

    fun map(posts: PostEntity?): List<PostModel> {
        val emptyList: MutableList<PostModel>
        emptyList= arrayListOf()
        /*posts?.forEach {
            emptyList.add(PostModel(body, id, title, userId))
        }*/
        return emptyList
    }

}