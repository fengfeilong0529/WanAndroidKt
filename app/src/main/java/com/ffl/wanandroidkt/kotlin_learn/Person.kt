package com.ffl.wanandroidkt.kotlin_learn

open class Person(var mName: String, var mAge: Int) {

    lateinit var name: String

    var address: String = "中国"
        get() = field.toUpperCase()
        set

    var no: Int = 10
        get
        set(value) {
            if (value > 20) {
                field = 20
            } else if (value < 5) {
                field = 5
            } else {
                field = value
            }
        }

    var height: Float = 171.4f
        private set

    //相当于主构造函数的函数体
    init {
        println("我是主构造函数执行语句")
    }

    constructor(name: String, age: Int, gender: String, address: String) : this(name, age) {
        println("我是基类次级构造函数，会间接调用主构造函数")
        this.name = name
    }

    /**
     * 打球
     * 函数返回为空用Unit表示，相当于java的void，可省略不写
     * 返回值类型后面加？， 表示可返回null
     */
    open fun playBall(type: String): String? {
        print("${this.name}" + "打" + type)
        return null
    }

    /**
     * 玩游戏
     * 主构造中参数如果声明了var或者val，就相当于在类中声明了对应名称的属性，则可以直接使用
     */
    open fun playGame(type: String): Unit {
        print(mName + "玩" + type)
        print(mName + "的年龄是" + mAge)
    }

    override fun toString(): String {
        return "Person(mName='$mName', mAge=$mAge, name='$name')"
    }
}