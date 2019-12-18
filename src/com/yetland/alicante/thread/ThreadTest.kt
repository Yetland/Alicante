package com.yetland.alicante.thread

object ThreadTest {

    @JvmStatic
    fun main(args: Array<String>) {
        val thread = ThreadInternal()
        thread.start()
    }

    internal class ThreadInternal : Thread() {
        override fun run() {
            println("thread run")
        }
    }
}