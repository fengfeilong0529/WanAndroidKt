package com.ffl.wanandroidkt.kotlin_learn

class Test {

    fun myTest() {
        val me = Fengfeilong("冯飞龙", 28, "男", "广东深圳")
        print("人名：${me.name},年龄是：${me.mAge}")
        me.playBall("篮球")

        var person = Person("老王", 20)
        person.no = 200
        person.address = "广东深圳"

        print("姓名：${person.name}，年龄：${person.mAge},编号:${person.no},地址：${person.address}")
    }
}