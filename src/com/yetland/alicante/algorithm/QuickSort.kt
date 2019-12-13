package com.yetland.alicante.algorithm

object QuickSort {
    @JvmStatic
    fun main(args: Array<String>) {
        var array: IntArray = intArrayOf(1, 43, 5345, 64, 234, 12, 34, 654, 12, 24, 4, 3, 54, 12, 2, 34, 43)
        println("arrayCount = ${array.size}")
        println("before")
        array.forEach {
            print("$it , ")
        }
        println()
        println("============================================================================")
        array = quickSort(array, 0, array.size - 1)
        println("after")
        array.forEach {
            print("$it , ")
        }
    }

    private fun quickSort(array: IntArray, start: Int, end: Int): IntArray {
        // 如果数组是空，或者开始值小于0，或者开始值大于结束，或者结束值大于等于array长度
        if (array.isEmpty() || start < 0 || end >= array.size || start > end)
            return array
        val smallIndex = partition(array, start, end)
        if (smallIndex > start)
            quickSort(array, start, smallIndex - 1)
        if (smallIndex < end)
            quickSort(array, smallIndex + 1, end)
        return array
    }

    private fun partition(array: IntArray, start: Int, end: Int): Int {
        val pivot = (start + Math.random() * (end - start + 1)).toInt()
        var smallIndex = start - 1
        println("pivot = $pivot , smallIndex = $smallIndex , start = $start , end = $end")
        swap(array, pivot, end)
        for (i in start..end)
            if (array[i] <= array[end]) {
                smallIndex++
                if (i > smallIndex)
                    swap(array, i, smallIndex)
            }
        array.forEach {
            print("$it , ")
        }
        println()
        println("============================================================================")
        return smallIndex
    }

    private fun swap(array: IntArray, i: Int, j: Int) {
        val temp = array[i]
        array[i] = array[j]
        array[j] = temp
    }
}