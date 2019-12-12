package com.yetland.alicante.adapter

/**
 * @author: YETLAND
 * @create: 2019-11-28 13:51
 **/
interface TypePool {
    fun <T> register(clazz: Class<T>, binder: ViewBinder<T>)
    fun firstIndexOf(clazz: Class<*>): Int
    fun getClasses(): List<Class<*>>
    fun getViewBinders(): List<ViewBinder<Any>>
}