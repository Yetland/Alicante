package com.yetland.alicante.algorithm

object BubbleSort {

    @JvmStatic
    fun main(args: Array<String>) {

        val array: IntArray = intArrayOf(1, 43, 5345, 64, 234, 12, 34, 654, 12, 24, 4, 3, 54, 12, 2, 34, 43)
        println("arrayCount = ${array.size}")
        array.forEach {
            print("$it , ")
        }
        println()
        println("before")
        println("============================================================================")
        bubbleSort(array)
        println("after")
        array.forEach {
            print("$it , ")
        }
    }

    private fun bubbleSort(array: IntArray): IntArray {
        var modCount = 0
        for (i in array.indices) {
            modCount++
            // 为什么要-1?因为j需要+1，不然会越界
            for (j in 0 until array.size - i - 1) {
                modCount++
                if (array[j] > array[j + 1]) {
                    val temp = array[j + 1]
                    array[j + 1] = array[j]
                    array[j] = temp
                }
            }
        }
        println("modCount = $modCount")
        return array
    }
}