package com.app.baseprojectamanattri.data.mapper

import com.app.baseprojectamanattri.framework.api.Post

class UserMapper {

    fun map(posts: List<Post>?): List<com.app.baseprojectamanattri.domain.models.Post> {
        val emptyList: MutableList<com.app.baseprojectamanattri.domain.models.Post>
        emptyList= arrayListOf()
        posts?.forEach {
            emptyList.add(com.app.baseprojectamanattri.domain.models.Post())
        }
        return emptyList
    }

}