package com.yetland.alicante.algorithm

object QuickSort {
    @JvmStatic
    fun main(args: Array<String>) {
        var array: IntArray = intArrayOf(3, 5, 7, 2, 6, 1, 3, 8, 4)
        println("arrayCount = ${array.size}")
        println("before")
        array.forEach {
            print("$it , ")
        }
        println()
        println("============================================================================")
        array = quickSort2(array, 0, array.size - 1)
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


    // 取基准值，然后比较
    private fun quickSort2(array: IntArray, start: Int, end: Int): IntArray {

        if (start >= end) {
            return array
        }
        val pivotValue = array[start]
        var left = start
        var right = end

        while (left < right) {
            while (left < right) {
                if (array[right] < pivotValue) {
                    array[left] = array[right]
                    break
                }
                right--
            }
            while (left < right) {
                if (array[left] > pivotValue) {
                    array[right] = array[left]
                    break
                }
                left++
            }
        }
        array[left] = pivotValue
        quickSort2(array, start, right - 1)
        quickSort2(array, right + 1, end)
        return array
    }
}