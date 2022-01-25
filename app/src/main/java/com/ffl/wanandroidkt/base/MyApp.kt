package com.ffl.wanandroidkt.base

import android.app.Application
import android.content.Context
import androidx.appcompat.app.AppCompatDelegate
import com.ffl.baselib.helper.MMKVHelper
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
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
        MMKVHelper.getInstance().init(this)
        Logger.addLogAdapter(AndroidLogAdapter())

        if (MMKVHelper.getInstance().getBoolean(Constants.KEY_NIGHT_MODE, false))
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        else
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
    }

}