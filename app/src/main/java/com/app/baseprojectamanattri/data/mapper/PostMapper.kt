package com.app.baseprojectamanattri.data.mapper

import com.app.baseprojectamanattri.data.entities.PostEntity
import com.app.baseprojectamanattri.domain.post.models.PostModel

object PostMapper {

    fun map(posts: PostEntity?): List<PostModel> {
        val emptyList: MutableList<PostModel>
        emptyList= arrayListOf()
        posts?.forEach {
            emptyList.add(PostModel())
        }
        return emptyList
    }

}