package com.app.baseprojectamanattri.framework.datasourceImp

import com.app.baseprojectamanattri.framework.api.RestApi
import com.app.baseprojectamanattri.data.datasource.RemoteDataSource

class RemotDataSourceImp: RemoteDataSource {

    lateinit var restapi: RestApi

    override fun login(username: String, password: String) {
        TODO("Not yet implemented")
    }
}