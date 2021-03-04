package com.app.baseprojectamanattri.data.repo

import com.app.baseprojectamanattri.data.FactoryDataSource

class RepositaryImp {

     var factoryDataSource: FactoryDataSource = FactoryDataSource();

     fun getPosts() {
        factoryDataSource.getLoginSource().getPosts()
     }


}