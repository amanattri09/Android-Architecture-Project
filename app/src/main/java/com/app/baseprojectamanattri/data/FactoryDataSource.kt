package com.app.baseprojectamanattri.data

import com.app.baseprojectamanattri.framework.datasourceImp.RemotDataSourceImp

class FactoryDataSource {

    fun getLoginSource(): RemotDataSourceImp {
        return RemotDataSourceImp()
    }

}