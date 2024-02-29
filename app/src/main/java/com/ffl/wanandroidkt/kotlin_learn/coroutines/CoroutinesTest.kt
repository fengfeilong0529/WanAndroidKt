package com.ffl.wanandroidkt.kotlin_learn.coroutines

import android.util.Log
import kotlinx.coroutines.*

/**
 * 协程练习
 * https://zhuanlan.zhihu.com/p/101489392
 */
class CoroutinesTest {

    fun test1() {
        GlobalScope.launch {
            delay(1000)
            println("延时1s发送的消息")
        }
        println("111")
        Thread.sleep(2000)
        println("222")
    }

    fun test2() {
        val async = GlobalScope.async {
            delay(1000)
            println("延时1s发送的消息")
        }
        println("111")
        Thread.sleep(2000)
        println("222")
    }

    fun test3() {
        // Dispatchers.Main可以省略
        GlobalScope.launch(Dispatchers.Main) {
            val name = withContext(Dispatchers.IO) {
                //模拟网络请求
                requestNet()
            }
            println("请求到的姓名是=>$name")
            //展示UI
//            tvName.text=name
        }
    }

    private suspend fun requestNet(): String {
        Log.d("coroutine", "requestNet: ${Thread.currentThread().name}")
        delay(2000)
        return "测试name"
    }

}