package com.ffl.wanandroidkt.kotlin_learn

/**
 * 语法练习
 * https://www.runoob.com/kotlin/kotlin-basic-syntax.html
 */
class Grammar {

    /**
     * 函数定义
     */
    fun sum(a: Int, b: Int): Int {
        prints(1, 2, 2, 3, 4, 5)
        return a + b
    }

    // 自动推断返回类型
    fun sum(a: Int, b: Int, c: Int) = a + b + c

    // public 方法则必须明确写出返回类型
    public fun sum2(a: Int, b: Int): Int = a + b

    // 无返回值
    fun sayHello(): Unit = println("Hello!")

    // 无返回值，可省略
    fun sayHi() = println("Hi!")


    //vararg 可变参数
    fun prints(vararg v: Int) {
        for (i in v) {
            println(i)
        }
        println(sumLambda(3, 4))
    }

    /**
     * lambda(匿名函数)
     */
    val sumLambda: (Int, Int) -> Int = { x, y -> x + y }

    /**
     * var <标识符> : <类型> = <初始化值>
     * val <标识符> : <类型> = <初始化值>
     *
     *     常量与变量都可以没有初始化值,但是在引用前必须初始化
     *     编译器支持自动类型判断,即声明时可以不指定类型,由编译器判断。
     */

    //可变变量
    var changableValue = 4

    //不可变变量，常量，类似于java中被final修饰的编量
    val unChangableValue = 40

    fun aaa() {
        val a: Int = 1
        val b = 1       // 系统自动推断变量类型为Int
        val c: Int      // 如果不在声明时初始化则必须提供变量类型
        c = 1           // 明确赋值
        print(c)

        var x = 5        // 系统自动推断变量类型为Int
        x += 1           // 变量可修改
    }


    /**
     * 注释
     *
     * Kotlin 支持单行和多行注释，实例如下：
     * 与 Java 不同, Kotlin 中的块注释允许嵌套。
     */
    // 这是一个单行注释

    /* 这是一个多行的
        块注释。 */

    /**
     * 字符串模板
     *
     * $ 表示一个变量名或者变量值
     * $varName 表示变量值
     * ${varName.fun()} 表示变量的方法返回值:
     */
    fun b() {
        var a = 1
        // 模板中的简单名称：
        val s1 = "a is $a"  //a is 1

        a = 2
        // 模板中的任意表达式：
        val s2 = "${s1.replace("is", "was")}, but now is $a"
        print(s2)   //a was 1,bus now is 2
    }

    /**
     * NULL检查机制
     *
     * Kotlin的空安全设计对于声明可为空的参数，在使用时要进行空判断处理，有两种处理方式，字段后加!!像Java一样抛出空异常，
     * 另一种字段后加?可不做处理返回值为 null或配合?:做空判断处理
     *
     * 当一个引用可能为 null 值时, 对应的类型声明必须明确地标记为可为 null
     */
    fun c() {
        //类型后面加?表示可为空
        var age: String? = "23"
        //抛出空指针异常
        val ages = age!!.toInt()
        //不做处理返回 null
        val ages1 = age?.toInt()
        //age为空返回-1
        val ages2 = age?.toInt() ?: -1
    }

    //当 str 中的字符串内容不是一个整数时, 返回 null
    fun parseInt(str: String): Int? {
        return str.toInt()
    }

    /**
     * 类型检测及自动类型转换
     * is
     * 类似于Java中的instanceof关键字
     */
    fun getStringLength(obj: Any): Int? {
        if (obj is String) {
            // 做过类型判断以后，obj会被系统自动转换为String类型
            return obj.length
        }

        //在这里还有一种方法，与Java中instanceof不同，使用!is
        // if (obj !is String){
        //   // XXX
        // }

        // 这里的obj仍然是Any类型的引用
        return null
    }

    fun getStringLength2(obj: Any): Int? {
        if (obj !is String)
            return null
        // 在这个分支中, `obj` 的类型会被自动转换为 `String`
        return obj.length
    }

    fun getStringLength3(obj: Any): Int? {
        // 在 `&&` 运算符的右侧, `obj` 的类型会被自动转换为 `String`
        if (obj is String && obj.length > 0)
            return obj.length
        return null
    }


    /**
     * 区间
     *
     * 区间表达式由具有操作符形式 .. 的 rangeTo 函数辅以 in 和 !in 形成
     *
     * 区间是为任何可比较类型定义的
     */
    fun cc() {
        for (i in 1..5) print(i)    //1,2,3,4,5
        for (i in 5..1) print(i)    //什么都不输出

        val j =3
        if (j in 1..10) { // 等同于 1 <= j && j <= 10
            println(j)
        }

        // 使用 step 指定步长
        for (i in 1..4 step 2) print(i) // 输出“13”

        for (i in 4 downTo 1 step 2) print(i) // 输出“42”

        // 使用 until 函数排除结束元素
        for (i in 1 until 10) {   // i in [1, 10) 排除了 10       输出123456789
            println(i)
        }
    }

}