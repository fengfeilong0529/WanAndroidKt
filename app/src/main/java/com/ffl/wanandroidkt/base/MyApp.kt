package com.ffl.wanandroidkt.base

import android.app.Application
import android.content.Context
import kotlin.properties.Delegates

class MyApp : Application() {

    companion object {

        lateinit var mInstance: MyApp

        var context: Context by Delegates.notNull()
            private set

    }

    override fun onCreate() {
        super.onCreate()
        mInstance = this
        context = applicationContext
    }

}