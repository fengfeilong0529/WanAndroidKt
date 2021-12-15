package com.ffl.wanandroidkt.kotlin_learn

class ArrayAndList {

    fun test(){
        val numArray = arrayOf(1, 2, 3, 4, 5)
        var numList = listOf<Int>(3, 4, 5, 6, 7)
        for (index in numList.indices) {
            println(index)
        }
    }
}