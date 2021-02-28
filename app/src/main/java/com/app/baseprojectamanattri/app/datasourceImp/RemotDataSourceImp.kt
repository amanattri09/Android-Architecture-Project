package com.app.baseprojectamanattri.app.datasourceImp

import com.app.baseprojectamanattri.app.RestApi
import com.app.baseprojectamanattri.data.datasource.RemoteDataSource

class RemotDataSourceImp: RemoteDataSource {

    lateinit var restapi:RestApi

    override fun login(username: String, password: String) {
        TODO("Not yet implemented")
    }
}