package com.app.baseprojectamanattri.data.remote.post.entities

import com.app.baseprojectamanattri.domain.post.models.PostModel

data class PostEntity( val posts:ArrayList<PostEntityItem>)

data class PostEntityItem(
    val body: String,
    val id: Int,
    val title: String,
    val userId: Int
) {
    fun mapToModel(): PostModel {
        return PostModel(body,id,title,userId)
    }
}
