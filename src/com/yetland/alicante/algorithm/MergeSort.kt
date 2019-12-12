package com.yetland.alicante.algorithm

import java.util.*


object MergeSort {
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
        array = mergeSort(array)
        println("after")
        array.forEach {
            print("$it , ")
        }

    }

    private fun mergeSort(array: IntArray): IntArray {
        println("mergeSort")
        if (array.size < 2) return array
        val mid = array.size / 2
        val left: IntArray = Arrays.copyOfRange(array, 0, mid)
        val right = Arrays.copyOfRange(array, mid, array.size)
        println("left array ")
        left.forEach {
            print("$it , ")
        }
        println()
        println("*****************")
        println("right array ")
        right.forEach {
            print("$it , ")
        }
        println()
        println("*****************")
        return merge(mergeSort(left), mergeSort(right))
    }

    // 将两个数组合并成一个
    private fun merge(left: IntArray, right: IntArray): IntArray {
        println("merge")
        println("left array ")
        left.forEach {
            print("$it , ")
        }
        println()
        println("-----------------------")
        println("right array ")
        right.forEach {
            print("$it , ")
        }
        println()
        println("-----------------------")
        val result = IntArray(left.size + right.size)
        // 左边数组index
        var leftIndex = 0
        // 右边数组index
        var rightIndex = 0
        for (index in 0 until result.size) {
            println("index = $index , leftIndex = $leftIndex , rightIndex = $rightIndex")
            when {
                leftIndex >= left.size -> {
                    // 如果index比size还大，说明已经left已经取完了，接下来只要放right就好了
                    println("leftIndex out of bounds")
                    result[index] = right[rightIndex++]
                }
                rightIndex >= right.size -> {
                    // 如果index比size还大，说明已经right已经取完了，接下来只要放left就好了
                    println("rightIndex out of bounds")
                    result[index] = left[leftIndex++]
                }
                left[leftIndex] < right[rightIndex] -> {
                    // 这个要考虑到 /2取整之后的余数问题，左边的肯定不会小于右边的数量，所以要先放右边的
                    println("leftArray is smaller")
                    result[index] = left[leftIndex++]
                }
                else -> {
                    println("rightArray is smaller")
                    result[index] = right[rightIndex++]
                }
            }
        }
        return result
    }
}