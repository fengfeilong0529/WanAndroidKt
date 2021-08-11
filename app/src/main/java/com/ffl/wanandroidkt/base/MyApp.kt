package com.ffl.wanandroidkt.base

import android.app.Application

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        mInstance = this
    }

    companion object {

        private lateinit var mInstance: MyApp

        fun getInstance() = mInstance

        fun getContext() = mInstance.applicationContext
    }

}