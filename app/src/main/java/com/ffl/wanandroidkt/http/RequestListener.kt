package com.ffl.wanandroidkt.http

interface RequestListener<T> {
    fun onSuccess(data:T)

    fun onFail(str:String)
}