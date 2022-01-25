package com.ffl.wanandroidkt.kotlin_learn.coroutines

import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel

class LifeActivity : AppCompatActivity(), CoroutineScope by MainScope() {


    override fun onDestroy() {
        super.onDestroy()
        cancel()
    }
}