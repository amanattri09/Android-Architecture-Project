package com.app.baseprojectamanattri.network

class NetworkError(val errorCode: Int, override val message: String?) : Throwable(message)
