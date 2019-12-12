package com.yetland.alicante.thread

object ThreadTest {

    @JvmStatic
    fun main(args: Array<String>) {
        val thread = Thread(Runnable {
            print(System.currentTimeMillis())
            println("run")
        })
        thread.start()
        thread.join(3000)
        print(System.currentTimeMillis())
        println("ok")
//        try {
//            thread.interrupt()
//            println("interrupt")
//        } catch (e: Throwable) {
//            e.printStackTrace()
//        }
    }
}