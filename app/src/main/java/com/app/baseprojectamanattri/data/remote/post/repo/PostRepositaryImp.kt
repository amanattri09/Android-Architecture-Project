package com.app.baseprojectamanattri.data.remote.post.repo

import com.app.baseprojectamanattri.data.local.SharedPrefManager
import com.app.baseprojectamanattri.domain.post.models.PostModel
import com.app.baseprojectamanattri.domain.post.repositary.PostRepositary
import com.app.baseprojectamanattri.network.ConnectionHelper
import com.app.baseprojectamanattri.network.api.ApiService
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

class PostRepositaryImp @Inject constructor(
    val apiService: ApiService,
    val sharedPrefManager: SharedPrefManager,
    val connectionHelper: ConnectionHelper,
) : PostRepositary {

    private val posts: List<PostModel>? = null
        get() = field ?: sharedPrefManager.getPosts()


    override fun getPostsRx(): Single<List<PostModel>> {
        return if (connectionHelper.isConnected()) {
            apiService.listReposRx().map {
                it.map {
                    it.mapToModel()
                }
            }.doOnSuccess {
                sharedPrefManager.savePosts(it)
            }
        } else {
            Single.defer {
                return@defer Single.just(posts?: listOf())
            }
        }
    }

    override fun getPost(postId: String): Single<PostModel> {
        return apiService.getPostById(postId).map {
            it.mapToModel()
        }
    }


}
