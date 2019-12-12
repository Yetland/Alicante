package com.yetland.alicante.proxy

import java.lang.reflect.*
import java.lang.reflect.Proxy


object Main {
    @JvmStatic
    fun main(args: Array<String>) {
        val callback = object : Callback<String> {
            override fun callback(t: Response<String>) {
                t.t?.forEach {
                    println(it)
                }
            }
        }
        val hello = CustomProxy().create(Hello::class.java)
        hello.morning("morning").execute(callback)
        hello.afternoon("Afternoon").execute(callback)
        hello.evening("evening").execute(callback)
    }
}

interface Hello {
    fun morning(name: String): Call<String>
    fun afternoon(name: String): Call<String>
    fun evening(name: String): Call<String>
}

interface Call<T> {
    fun execute(callback: Callback<T>)
}

interface Callback<T> {
    fun callback(t: Response<T>)
}

class Worker<T> : Call<T> {

    var t: List<T>? = null
    override fun execute(callback: Callback<T>) {
        val response = Response<T>()
        response.t = t
        callback.callback(response)
    }
}

class Response<T> {

    var t: List<T>? = null
}

class CustomProxy : InvocationHandler {

    fun <T> create(clazz: Class<T>): T {
        return Proxy.newProxyInstance(clazz.classLoader, arrayOf(clazz), this) as T
    }

    override fun invoke(proxy: Any, method: Method, args: Array<out Any>?): Any? {
        println(method.genericReturnType)
        val type = method.genericReturnType

        val worker = Worker<Any>()
        worker.t = args?.toList()
        return worker
    }

    fun getRawType(type: Type): Class<*> {

        if (type is Class<*>) {
            // Type is alicante normal class.
            return type
        }
        if (type is ParameterizedType) {
            // I'm not exactly sure why getRawType() returns Type instead of Class. Neal isn't either but
            // suspects some pathological case related to nested classes exists.
            return type.rawType as? Class<*> ?: throw IllegalArgumentException()
        }
        if (type is TypeVariable<*>) {
            // We could use the variable's bounds, but that won't work if there are multiple. Having alicante raw
            // type that's more general than necessary is okay.
            return Any::class.java
        }
        if (type is WildcardType) {
            return getRawType(type.upperBounds[0])
        }

        throw IllegalArgumentException("Expected alicante Class, ParameterizedType, or "
                + "GenericArrayType, but <" + type + "> is of type " + type.javaClass.name)
    }
}