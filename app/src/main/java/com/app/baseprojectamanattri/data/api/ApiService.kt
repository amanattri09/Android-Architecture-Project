package com.app.baseprojectamanattri.data.api

import com.app.baseprojectamanattri.data.entities.PostEntity
import retrofit2.Call
import retrofit2.http.GET


interface ApiService {
    @GET("/posts")
    fun listRepos(): Call<PostEntity>
}