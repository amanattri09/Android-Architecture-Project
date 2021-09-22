package com.app.baseprojectamanattri.network.api

import com.app.baseprojectamanattri.data.remote.post.entities.PostEntity
import com.app.baseprojectamanattri.data.remote.post.entities.PostEntityItem
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface ApiService {

    @GET("/posts")
    fun listReposRx(): Single<List<PostEntityItem>>

    @GET("/posts/{postId}")
    fun getPostById(@Path("postId") postId:String): Single<PostEntityItem>
}