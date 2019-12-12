package com.yetland.alicante.proxy

import java.lang.reflect.InvocationHandler
import java.lang.reflect.Method
import java.lang.reflect.Proxy

class DynamicProxy : InvocationHandler {
    private lateinit var proxyObject:Any
    fun bind(proxyObject: Any): Any {
        println("初始化")
        this.proxyObject = proxyObject
        return Proxy.newProxyInstance(proxyObject.javaClass.classLoader,
                proxyObject.javaClass.interfaces, this)
    }

    @Throws(Throwable::class)
    override fun invoke(proxy: Any, method: Method, args: Array<Any>): Any {
        return method.invoke(proxyObject, *args)
    }
}

interface Subject {
    // 定义目标对象的接口方法
    // 代购物品
    fun buy(name: String): String
}

// 小成，真正的想买Mac的对象 = 目标对象 = 被代理的对象
// 实现抽象目标对象的接口
class Buyer1 : Subject {

    override fun buy(name: String): String {
        println(name)
        return name
    }
}

fun main(args: Array<String>) {
    val subject: Subject = DynamicProxy().bind(Buyer1()) as Subject
    subject.buy("Mac")
}