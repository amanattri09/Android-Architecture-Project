package com.app.baseprojectamanattri.data.datasource

import androidx.lifecycle.Transformations.map
import com.app.baseprojectamanattri.data.mapper.UserMapper
import com.app.baseprojectamanattri.framework.api.Post
import com.app.baseprojectamanattri.framework.api.RestApi

class RemotDataSource : CommonDataSource() {

    private var restapi: RestApi= RestApi()

     fun getPosts(): List<com.app.baseprojectamanattri.domain.models.Post> {
        return UserMapper().map(restapi.getPosts())
    }
}