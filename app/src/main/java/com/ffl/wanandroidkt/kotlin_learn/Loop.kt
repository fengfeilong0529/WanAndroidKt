package com.ffl.wanandroidkt.kotlin_learn

class Loop {

    fun looptest() {

        for (i in 1..4) { // 1234
            println(i)
        }

        for (i in 1 until 4) { // 123
            println(i)
        }

        for (i in 4 downTo 1) {  //4321
            println(i)
        }

        for (i in 1..4 step 2) { //13
            println(i)
        }

        for (i in 4 downTo 1 step 2) {   //42
            println(i)
        }
    }
}