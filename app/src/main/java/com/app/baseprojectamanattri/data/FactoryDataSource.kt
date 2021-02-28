package com.app.baseprojectamanattri.data

import com.app.baseprojectamanattri.app.datasourceImp.RemotDataSourceImp

class FactoryDataSource {

    fun getLoginSource(): RemotDataSourceImp {
        return RemotDataSourceImp()
    }

}