package com.ffl.wanandroidkt.mvp.model

data class BaseModel<T>(val errorCode: Int, val errorMsg: String, val data: T)

