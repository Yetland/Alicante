package com.yetland.alicante

import java.util.function.Function

object FunctionTest {

    @JvmStatic
    fun main(args: Array<String>) {
        val h = F().compose<Long> {
            println("哈哈哈")
            it.toString()
        }

        val b = B()
        b.a(h)
    }

    class B {
        // 如果A无法直接变成B，需要进过一个过程，那么久需要通过compose方法做一层过度
        fun a(f: Function<Long, Int>) {
            println(f.apply(333))
        }
    }

    class F : Function<String, Int> {
        override fun apply(t: String): Int {
            return t.toInt()
        }
    }
}