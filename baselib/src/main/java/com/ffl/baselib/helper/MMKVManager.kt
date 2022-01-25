package com.ffl.baselib.helper

import android.content.Context
import android.os.Parcelable
import android.util.Log
import com.tencent.mmkv.MMKV
import kotlinx.coroutines.CoroutineScope

/**
 * MMKV存储管理类
 */
class MMKVManager private constructor() {

    companion object {
        private var mInstance: MMKVManager? = null

        fun getInstance(): MMKVManager {
            if (mInstance == null) {
                synchronized(MMKVManager::class.java) {
                    if (mInstance == null) {
                        mInstance = MMKVManager()
                    }
                }
            }
            return mInstance!!
        }
    }

    var defaultMMKV: MMKV? = null


    /**
     * 初始化
     */
    fun init(context: Context) {
        val rootDir = MMKV.initialize(context)
        Log.i("Application", "MMKV rootDir===> $rootDir")
    }

    fun getMMKV(): MMKV {
        if (defaultMMKV == null) {
            defaultMMKV = MMKV.defaultMMKV()
        }
        return defaultMMKV!!
    }

    fun putString(key: String, value: String) {
        getMMKV().encode(key, value)
    }

    fun putBoolean(key: String, value: Boolean) {
        getMMKV().encode(key, value)
    }

    fun putInt(key: String, value: Int) {
        getMMKV().encode(key, value)
    }

    fun getString(key: String): String? {
        return getMMKV().decodeString(key)
    }

    fun getBoolean(key: String): Boolean {
        return getMMKV().decodeBool(key)
    }

    fun getBoolean(key: String, defaultValue: Boolean): Boolean {
        return getMMKV().decodeBool(key, defaultValue)
    }

    fun getInt(key: String): Int {
        return getMMKV().decodeInt(key)
    }

    fun getInt(key: String, defaultValue: Int): Int {
        return getMMKV().decodeInt(key, defaultValue)
    }

}