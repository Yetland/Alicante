package com.yetland.alicante.binary

object BinaryTest {

    @JvmStatic
    fun main(args: Array<String>) {
        val binaryHello = BinaryHello()
        binaryHello.addFlag(BinaryHello.FLAG_A)
        binaryHello.hasFlag(BinaryHello.FLAG_A)
        binaryHello.addFlag(BinaryHello.FLAG_B)
        binaryHello.hasFlag(BinaryHello.FLAG_B)
        binaryHello.addFlag(BinaryHello.FLAG_C)
        binaryHello.hasFlag(BinaryHello.FLAG_C)
        binaryHello.removeFlag(BinaryHello.FLAG_A)
        binaryHello.hasFlag(BinaryHello.FLAG_A)
        binaryHello.removeFlag(BinaryHello.FLAG_B)
        binaryHello.hasFlag(BinaryHello.FLAG_B)
        binaryHello.removeFlag(BinaryHello.FLAG_C)
        binaryHello.hasFlag(BinaryHello.FLAG_C)
    }

    internal class BinaryHello {
        companion object {
            const val FLAG_A = 1
            const val FLAG_B = 2
            const val FLAG_C = 4
        }

        var result = 0

        fun addFlag(x: Int) {
            println("addFlag invoke. before = $result")
            result = result or x
            println("addFlag invoke. after = $result")
        }

        fun hasFlag(x: Int) {
            println("hasFlag invoke. hasFlag = ${result and x}")
        }

        fun removeFlag(x: Int) {
            println("removeFlag invoke. before = $result")
            result = result xor x
            println("removeFlag invoke. before = $result")
        }
    }

}