package com.yetland.alicante.thread

import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

/**
 * ①如果在线程池中的线程数量没有达到核心的线程数量，这时候就回启动一个核心线程来执行任务。
②如果线程池中的线程数量已经超过核心线程数，这时候任务就会被插入到任务队列中排队等待执行。
③由于任务队列已满，无法将任务插入到任务队列中。这个时候如果线程池中的线程数量没有达到线程池所设定的最大值，那么这时候就会立即启动一个非核心线程来执行任务。
④如果线程池中的数量达到了所规定的最大值，那么就会拒绝执行此任务，这时候就会调用RejectedExecutionHandler中的rejectedExecution方法来通知调用者。
 */
object ThreadPool {
    @JvmStatic
    fun main(args: Array<String>) {
        // 四种线程池分别是newFixedThreadPool,newCachedThreadPool,newScheduledThreadPool和newSingleThreadExecutor
        fixedThreadPool()
        cacheThreadPool()
        scheduledThreadPool()
        singleThreadPool()
    }

    private fun fixedThreadPool() {
        println("=================fixedThreadPool=================")
        val fixedThreadPool: ExecutorService = Executors.newFixedThreadPool(3)
        execute(fixedThreadPool)
        println("=================fixedThreadPool=================")
    }

    private fun cacheThreadPool() {
        println("=================cacheThreadPool=================")
        val cacheThreadPool: ExecutorService = Executors.newCachedThreadPool()
        execute(cacheThreadPool)
        println("=================cacheThreadPool=================")
    }

    private fun scheduledThreadPool() {
        println("=================scheduledThreadPool=================")
        val scheduledThreadPool: ExecutorService = Executors.newScheduledThreadPool(3)
        execute(scheduledThreadPool)
        println("=================scheduledThreadPool=================")
    }

    private fun singleThreadPool() {
        println("=================singleThreadPool=================")
        val singleThreadPool: ExecutorService = Executors.newSingleThreadExecutor()
        execute(singleThreadPool)
        println("=================singleThreadPool=================")
    }

    private fun execute(executorService: ExecutorService) {
        var i = 10
        while (i > 0) {
            executorService.submit {
                println("thread = ${Thread.currentThread().name} , i = $i")
            }
            i--
        }
        executorService.shutdownNow()
    }
}