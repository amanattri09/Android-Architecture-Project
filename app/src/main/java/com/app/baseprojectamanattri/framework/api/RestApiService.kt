package com.app.baseprojectamanattri.framework.api

import retrofit2.Call
import retrofit2.http.GET


interface RestApiService {
    @GET("posts")
    fun listRepos(): Call<List<Post>>
}