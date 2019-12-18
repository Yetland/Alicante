package com.yetland.alicante.thread

import java.util.concurrent.Callable
import java.util.concurrent.FutureTask

object CallableThread {

    @JvmStatic
    fun main(args: Array<String>) {
        val callable = CallableTest()
        val task = FutureTask(callable)
        val threadB = Thread(task)
        threadB.start()
        println(Thread.currentThread().name)
        println("thread return = ${task.get()}")
    }

    internal class CallableTest : Callable<Int> {
        override fun call(): Int {
            println(Thread.currentThread().name)
            return 3
        }
    }
}