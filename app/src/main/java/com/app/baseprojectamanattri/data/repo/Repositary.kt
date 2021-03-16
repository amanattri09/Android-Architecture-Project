package com.app.baseprojectamanattri.data.repo

import com.app.baseprojectamanattri.data.FactoryDataSource

class Repositary( val factoryDataSource: FactoryDataSource) {

     fun getPosts(): List<com.app.baseprojectamanattri.domain.models.Post> {
        return factoryDataSource.getLoginSource().getPosts()
     }


}