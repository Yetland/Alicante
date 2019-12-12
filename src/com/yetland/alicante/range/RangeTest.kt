package com.yetland.alicante.range

object RangeTest {
    @JvmStatic
    fun main(args: Array<String>) {
        for (i in 1..4) {
            println("..操作：$i")
        }
        println("-----------------")
        for (i in 10 downTo 0) {
            println("downTo操作：$i")
        }
        println("-----------------")
        for (i in 0 until 10 ){
            println("until操作：$i")
        }

    }
}