package com.app.baseprojectamanattri.data.repo

import com.app.baseprojectamanattri.data.FactoryDataSource

class RepositaryImp {

    lateinit var factoryDataSource: FactoryDataSource;

     fun login(usename: String, password: String) {
        factoryDataSource.getLoginSource().login(usename,password)
    }


}