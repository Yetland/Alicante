package com.yetland.alicante.thread

import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import java.util.concurrent.locks.ReentrantLock

object TicketsSellerSystem {
    @JvmStatic
    fun main(args: Array<String>) {
        val threadPool: ExecutorService = Executors.newFixedThreadPool(4)
        val ticket = Ticket()
        var i = 10
        while (i > 0) {
            threadPool.submit(ticket)
            i--
        }
        threadPool.shutdown()
    }

    /**
     * 1）Lock是一个接口，而synchronized是Java中的关键字，synchronized是内置的语言实现；
    2）synchronized在发生异常时，会自动释放线程占有的锁，因此不会导致死锁现象发生；而Lock在发生异常时，如果没有主动通过unLock()去释放锁，则很可能造成死锁现象，因此使用Lock时需要在finally块中释放锁；
    3）Lock可以让等待锁的线程响应中断，而synchronized却不行，使用synchronized时，等待的线程会一直等待下去，不能够响应中断；
    4）通过Lock可以知道有没有成功获取锁，而synchronized却无法办到。
    5）Lock可以提高多个线程进行读操作的效率。
     */
    internal class Ticket : Runnable {
        private var count = 5
        // ReentrantLock，一个可重入的互斥锁，
        // 它具有与使用synchronized方法和语句所访问的隐式监视器锁相同的一些基本行为和语义，但功能更强大。
        private val lock: ReentrantLock = ReentrantLock()

        override fun run() {
//            synchronized(this) {
//                if (count > 0) {
//                    count--
//                    println("${Thread.currentThread().name} buy one ticket , remain tickets count = $count")
//                } else {
//                    println("sorry ${Thread.currentThread().name}. the ticket sold out")
//                }
//            }
            lock.lock()
            if (count > 0) {
                count--
                println("${Thread.currentThread().name} buy one ticket , remain tickets count = $count")
            } else {
                println("sorry ${Thread.currentThread().name}. the ticket sold out")
            }
            lock.unlock()
        }
    }
}