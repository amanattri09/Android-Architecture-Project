package com.app.baseprojectamanattri.framework.api

import com.app.baseprojectamanattri.utilities.AppConstants
import retrofit2.Retrofit


class RetrofitAdapter {

    fun init() {
        var retrofit = Retrofit.Builder()
                .baseUrl(AppConstants.BASE_URL)
                .build()
        var service: RestApiService = retrofit.create(
            RestApiService::class.java)
    }

}