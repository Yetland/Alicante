package com.yetland.alicante.proxy

import java.lang.reflect.InvocationHandler
import java.lang.reflect.Method
import java.lang.reflect.Proxy

object ProxyTest {
    @JvmStatic
    fun main(args: Array<String>) {
        /* 设置此系统属性,让JVM生成的Proxy类写入文件.保存路径为：com/sun/proxy(如果不存在请手工创建) */
        val userImpl = DynamicProxy().bind(UserImpl()) as IUser
        userImpl.sayHello(" kevin LUAN")
    }

    class DynamicProxy : InvocationHandler {
        private lateinit var target: Any

        fun bind(target: Any): Any {
            this.target = target
            return Proxy.newProxyInstance(target.javaClass.classLoader, target.javaClass.interfaces, this)
        }

        @Throws(Throwable::class)
        override fun invoke(proxy: Any, method: Method, args: Array<Any>): Any {
            return method.invoke(target, *args)
        }
    }

    interface IUser {
        fun sayHello(speakString: String):String
    }

    class UserImpl : IUser {

        override fun sayHello(speakString: String):String {
            println("welcome $speakString")
            return "welcome $speakString"
        }

    }
}
