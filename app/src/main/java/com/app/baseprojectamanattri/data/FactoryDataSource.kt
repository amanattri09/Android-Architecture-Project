package com.app.baseprojectamanattri.data

import com.app.baseprojectamanattri.data.datasource.RemotDataSource

class FactoryDataSource {

    fun getLoginSource(): RemotDataSource {
        return RemotDataSource()
    }

}