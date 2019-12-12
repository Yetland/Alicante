package com.yetland.alicante.algorithm

object InsertionSort {

    @JvmStatic
    fun main(args: Array<String>) {
//        val array: IntArray = intArrayOf(1, 43, 5345, 64, 234, 12, 34, 654, 12, 24, 4, 3, 54, 12, 2, 34, 43)
        val array: IntArray = intArrayOf(322, 4)
        println("arrayCount = ${array.size}")
        array.forEach {
            print("$it , ")
        }
        println()
        println("before")
        println("============================================================================")
        insertionSort(array)
        println("after")
        array.forEach {
            print("$it , ")
        }
    }

    private fun insertionSort(array: IntArray): IntArray {

        var modCount = 0
        var current: Int
        for (i in 0 until array.size - 1) {
            modCount++
            // 下一个值
            current = array[i + 1]
            // 当前索引
            var preIndex = i
            // 对比到第一个，如果当前的值比要比较的值大
            while (preIndex >= 0 && array[preIndex] > current) {
                modCount++
                // 比较的值后移一位
                array[preIndex + 1] = array[preIndex]
                // 索引值（要比较的index）往前进一位
                preIndex--
            }
            // 因为是先--的，所以需要+1
            array[preIndex + 1] = current
        }
        println("modCount = $modCount")
        return array
    }
}