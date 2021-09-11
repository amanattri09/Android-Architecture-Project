package com.app.baseprojectamanattri.network.api

import com.app.baseprojectamanattri.data.remote.post.entities.PostEntity
import com.app.baseprojectamanattri.data.remote.post.entities.PostEntityItem
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.GET


interface ApiService {
    @GET("/posts")
    fun listRepos(): Call<PostEntity>

    @GET("/posts")
    fun listReposRx(): Single<List<PostEntityItem>>
}