package com.ffl.wanandroidkt.kotlin_learn

class Fengfeilong : Person, IAction {

    constructor(name: String, age: Int) : super(name, age)

    constructor(name: String, age: Int, gender: String, address: String) : super(name, age, gender, address) {
        println("My Name： $name")
    }

    override fun walk() {
        println("走路")
    }

    override fun sleep() {
        println("冯飞龙睡觉")
    }

    override fun eat(food: String) {
        super.eat(food)
        println("冯飞龙吃$food")
    }

    override fun playBall(type: String): String {
        super.playBall(type)
        print("Fengfeilong ${this.name}" + "打" + type)
        return "打的好累"
    }

    override fun playGame(name: String) {
        super<Person>.playGame(name)
    }
}