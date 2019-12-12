package com.yetland.annotation

@Print("hello class")
object AnnotationTest {

    @Print("hello field")
    val field = "哈哈哈"

    @Print("hello method")
    fun hello() {

    }

    @JvmStatic
    fun main(args: Array<String>) {
        val a = AnnotationTest::class.java.isAnnotationPresent(Print::class.java)
        if (a) {
            val print = AnnotationTest::class.java.getAnnotation(Print::class.java)
            println(print.message)
        }
        val field = AnnotationTest::class.java.getDeclaredField("field")
        field.isAccessible = true
        val print = field.getAnnotation(Print::class.java)
        if (print != null) {
            println(print.message)
        }
        val method = AnnotationTest::class.java.declaredMethods
        method?.forEach {
            it.annotations?.forEach {
                if (Print::class.java.isInstance(it)) {
                    println((it as Print).message)
                }
            }
        }
    }
}