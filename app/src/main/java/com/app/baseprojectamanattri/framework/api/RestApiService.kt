package com.app.baseprojectamanattri.framework.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface RestApiService {
    @GET("users/{user}/repos")
    fun listRepos(@Path("user") user: String?): Call<List<Repo?>?>?
}