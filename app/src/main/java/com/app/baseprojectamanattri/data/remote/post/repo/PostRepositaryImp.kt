package com.app.baseprojectamanattri.data.remote.post.repo

import com.app.baseprojectamanattri.network.api.ApiService
import com.app.baseprojectamanattri.data.remote.post.mapper.PostMapper
import com.app.baseprojectamanattri.domain.post.models.PostModel
import com.app.baseprojectamanattri.domain.post.repositary.PostRepositary
import io.reactivex.Single
import javax.inject.Inject

class PostRepositaryImp @Inject constructor(val apiService: ApiService) :PostRepositary {

    override fun getPostsRx(): Single<List<PostModel>> {
        return apiService.listReposRx().map {
            it.map {
                it.mapToModel()
            }
        }
    }

    override fun getPostsByCoroutines(): List<PostModel>? {
        var posts = apiService.listRepos().execute().body()
        return PostMapper.map(posts)
    }

}
