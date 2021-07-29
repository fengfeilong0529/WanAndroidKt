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
        me.sayHi()
    }

    /**
     * 扩展函数
     */
    fun Fengfeilong.sayHi(){
        println("HI!")
        val user = User("Jack", 20)
        val copy = user.copy(name = "Feilong", age = 27)
        println(user.toString())
        println(copy.toString())


        val (name1, age) = user.copy(name = "Feilong2", age = 28)
        println("$name1, $age years of age")
    }

    /**
     * 数据类，不能被open、abstract、inner、sealed等修饰
     *
     * 标准库提供了 Pair 和 Triple 。在大多数情形中，命名数据类是更好的设计选择，因为这样代码可读性更强而且提供了有意义的名字和属性。
     */
    data class User(val name: String, val age: Int)



}