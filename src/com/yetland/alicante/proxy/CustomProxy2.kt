//package com.yetland.alicante.proxy
//
//import java.lang.reflect.InvocationHandler
//import java.lang.reflect.Method
//import java.lang.reflect.Proxy
//
//object Main {
//    @JvmStatic
//    fun main(args: Array<String>) {
//        val callback = object : Callback<String> {
//            override fun callback(t: Response<String>) {
//                t.t?.forEach {
//                    println(it)
//                }
//            }
//        }
//        val hello = CustomProxy().create(Hello::class.java)
//        hello.morning("morning").execute(callback)
//        hello.afternoon("Afternoon").execute(callback)
//        hello.evening("evening").execute(callback)
//    }
//}
//
//interface Hello {
//    fun morning(name: String): Call<String>
//    fun afternoon(name: String): Call<String>
//    fun evening(name: String): Call<String>
//}
//
//interface Call<T> {
//    fun execute(callback: Callback<T>)
//}
//
//interface Callback<T> {
//    fun callback(t: Response<T>)
//}
//
//class Worker<T> : Call<T> {
//
//    var t: Array<out T>? = null
//    override fun execute(callback: Callback<T>) {
//        val response = Response<T>()
//        response.t = t
//        callback.callback(response)
//    }
//}
//
//class Response<T> {
//    var t: Array<out T>? = null
//}
//
//class CustomProxy : InvocationHandler {
//
//    fun <T> create(clazz: Class<T>): T {
//        return Proxy.newProxyInstance(clazz.classLoader, arrayOf(clazz), this) as T
//    }
//
//    override fun invoke(proxy: Any, method: Method, args: Array<out Any>?): Any? {
//        val worker = Worker<Any>()
//        worker.t = args
//        return worker
//    }
//
//}