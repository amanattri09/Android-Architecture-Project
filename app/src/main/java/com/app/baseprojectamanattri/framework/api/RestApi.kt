package com.app.baseprojectamanattri.framework.api

class RestApi {

    var restService:RetrofitAdapter

    init {
        restService=RetrofitAdapter()
    }
    fun getPosts(): List<Post>? {
        var response = restService.getRestService().listRepos().execute()
        return response.body();
    }
}