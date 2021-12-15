package com.ffl.wanandroidkt.kotlin_learn

interface IAction {
    fun walk()

    fun sleep() {
        println("睡觉")
    }

    fun eat(food: String) {
        println("吃$food")
    }
}