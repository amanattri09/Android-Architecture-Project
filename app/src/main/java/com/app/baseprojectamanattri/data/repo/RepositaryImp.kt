package com.app.baseprojectamanattri.data.repo

import com.app.baseprojectamanattri.data.FactoryDataSource

class RepositaryImp : Repositary {

    lateinit var factoryDataSource: FactoryDataSource;

    override fun login(usename: String, password: String) {
        factoryDataSource.getLoginSource().login(usename,password)
    }


}