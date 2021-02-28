package com.app.baseprojectamanattri.data.datasource

interface RemoteDataSource : CommonDataSource{
    fun login( username:String,password:String);
}