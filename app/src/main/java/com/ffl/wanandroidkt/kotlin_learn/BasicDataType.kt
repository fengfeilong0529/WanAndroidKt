package com.ffl.wanandroidkt.kotlin_learn

/**
 * Kotlin基础数据类型
 * https://www.runoob.com/kotlin/kotlin-basic-types.html
 *
 * Kotlin 的基本数值类型包括 Byte、Short、Int、Long、Float、Double 等。
 * 不同于 Java 的是，字符不属于数值类型，是一个独立的数据类型。
 *
 * 位宽度
 * Double	64
 * Float	32
 * Long	    64
 * Int	    32
 * Short	16
 * Byte	    8
 */
class BasicDataType {

    val oneMillion = 1_000_000
    val creditCardNumber = 1234_5678_9012_3456L
    val socialSecurityNumber = 999_99_9999L
    val hexBytes = 0xFF_EC_DE_5E
    val bytes = 0b11010010_01101001_10010100_10010010

    /**
     * 比较两个数字
     *
     * 三个等号 === 表示比较对象地址，两个 == 表示比较两个值大小
     */
    fun compareInt() {
        val a: Int = 10000
        println(a === a) // true，值相等，对象地址相等

        //经过了装箱，创建了两个不同的对象
        val boxedA: Int? = a
        val anotherBoxedA: Int? = a

        //虽然经过了装箱，但是值是相等的，都是10000
        println(boxedA === anotherBoxedA) //  false，值相等，对象地址不一样
        println(boxedA == anotherBoxedA) // true，值相等
    }

    /**
     * 类型转换
     *
     */
    fun a() {
        val b: Byte = 1 // OK, 字面值是静态检测的
//        val i: Int = b // 错误

        //我们可以代用其toInt()方法。

        val b2: Byte = 1 // OK, 字面值是静态检测的
        val i2: Int = b2.toInt() // OK

        val l = 1L + 3 // Long + Int => Long
    }

    /**
     * 字符
     *
     * 和 Java 不一样，Kotlin 中的 Char 不能直接和数字操作，Char 必需是单引号 ' 包含起来的。比如普通字符 '0'，'a'。
     */
    fun check(c: Char) {
//        if (c == 1) { // 错误：类型不兼容
        if (c == '1') { // OK
            // ……
        }
    }

    //字符字面值用单引号括起来: '1'。 特殊字符可以用反斜杠转义。 支持这几个转义序列：\t、 \b、\n、\r、\'、\"、\\ 和 \$。
    // 编码其他字符要用 Unicode 转义序列语法：'\uFF00'。

    fun decimalDigitValue(c: Char): Int {
        if (c !in '0'..'9')
            throw IllegalArgumentException("Out of range")
        return c.toInt() - '0'.toInt() // 显式转换为数字
    }

    /**
     * 数组
     *
     * 数组的创建两种方式：
     * 一种是使用函数arrayOf()；另外一种是使用工厂函数。
     */
    fun main() {
        //[1,2,3]
        val a = arrayOf(1, 2, 3)
        //[0,2,4]
        val b = Array(3, { i -> (i * 2) })  //todo 啥意思？

        //读取数组内容
        println(a[0])    // 输出结果：1
        println(b[1])    // 输出结果：2
    }
}