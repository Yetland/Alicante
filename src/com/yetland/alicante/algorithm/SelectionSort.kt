package com.yetland.alicante.algorithm

object SelectionSort {

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
        selectionSort(array)
        println("after")
        array.forEach {
            print("$it , ")
        }
    }

    private fun selectionSort(array: IntArray): IntArray {
        var modCount = 0
        for (i in 0 until array.size) {
            modCount++
            var minIndex = i
            for (j in i until array.size) {
                modCount++
                if (array[j] < array[minIndex]) {
                    minIndex = j
                }
            }
            val temp = array[i]
            array[i] = array[minIndex]
            array[minIndex] = temp
        }
        println("modCount = $modCount")
        return array
    }
}
