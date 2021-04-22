package com.app.baseprojectamanattri.domain.post.repositary

import com.app.baseprojectamanattri.domain.post.models.PostModel

interface PostRepositary {
     fun getPosts(): List<PostModel>?
}