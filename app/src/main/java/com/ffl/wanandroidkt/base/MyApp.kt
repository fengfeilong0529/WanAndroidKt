package com.ffl.wanandroidkt.base

import android.app.Application
import android.content.Context
import android.util.Log
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import com.tencent.mmkv.MMKV
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
        val rootDir = MMKV.initialize(this)
        Log.i("Application", "MMKV rootDir===> $rootDir")
        Logger.addLogAdapter(AndroidLogAdapter())
    }

}