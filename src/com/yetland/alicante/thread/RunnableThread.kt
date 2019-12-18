package com.yetland.alicante.thread

object RunnableThread {

    @JvmStatic
    fun main(args: Array<String>) {
        val thread = Thread(RunnableTest())
        thread.start()
    }

    internal class RunnableTest : Runnable {
        override fun run() {
            println(Thread.currentThread().name)
            println("runnable run")
        }
    }
}