package com.app.baseprojectamanattri.framework.api

import com.app.baseprojectamanattri.utilities.AppConstants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitAdapter {

    private lateinit var service: RestApiService

    init {
        init()
    }

    fun init() {
        var retrofit = Retrofit.Builder()
            .baseUrl(AppConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        service = retrofit.create(
            RestApiService::class.java
        )
    }

    fun getRestService(): RestApiService {
        return service;
    }

}