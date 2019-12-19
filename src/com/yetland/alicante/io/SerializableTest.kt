package com.yetland.alicante.io

import java.io.Serializable

object SerializableTest {
    @JvmStatic
    fun main(args: Array<String>) {
        val student = Student("class 1", 11)
        println(student)
    }

    internal data class Student(val className: String, val grade: Int) : Serializable
}