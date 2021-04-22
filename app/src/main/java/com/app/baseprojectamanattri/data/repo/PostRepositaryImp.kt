package com.app.baseprojectamanattri.data.repo

import com.app.baseprojectamanattri.data.api.ApiService
import com.app.baseprojectamanattri.data.mapper.PostMapper
import com.app.baseprojectamanattri.domain.post.models.PostModel
import com.app.baseprojectamanattri.domain.post.repositary.PostRepositary
import javax.inject.Inject

class PostRepositaryImp @Inject constructor(val apiService: ApiService) :PostRepositary {

    override fun getPosts(): List<PostModel>? {
        var posts = apiService.listRepos().execute().body()
        return PostMapper.map(posts)
    }

}
