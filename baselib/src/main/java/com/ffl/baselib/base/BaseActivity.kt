package com.ffl.baselib.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast

/**
 * Act基类
 * 实现：
 * 简单封装
 * toast、progressDialog显示
 */
abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        println("我是BaseActivity的oncreate()!")
        setContentView(getLayoutId())
        initView()
        initData()
    }

    abstract fun getLayoutId(): Int
    abstract fun initView()
    abstract fun initData()

    fun showToast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT)
    }


}