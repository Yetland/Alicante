package com.yetland.alicante.adapter

/**
 * @author: YETLAND
 * @create: 2019-11-28 13:57
 **/
class TypePoolFactory : TypePool {
    private var classes: MutableList<Class<*>> = mutableListOf()
    private var binderList: MutableList<ViewBinder<Any>> = mutableListOf()

    override fun <T> register(clazz: Class<T>, binder: ViewBinder<T>) {
        classes.add(clazz)
        binderList.add(binder as ViewBinder<Any>)
    }

    override fun firstIndexOf(clazz: Class<*>): Int {
        val index = classes.indexOf(clazz)
        if (index != -1) {
            return index
        }
        for (i in classes.indices) {
            if (classes[i].isAssignableFrom(clazz)) {
                return i
            }
        }
        return -1
    }

    override fun getClasses(): List<Class<*>> {
        return classes
    }

    override fun getViewBinders(): List<ViewBinder<Any>> {
        return binderList
    }

}