package com.ffl.baselib.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**
 * Act基类
 * 实现：
 * 简单封装
 * toast、progressDialog显示
 */
open class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        println("我是BaseActivity的oncreate()!")
    }
}