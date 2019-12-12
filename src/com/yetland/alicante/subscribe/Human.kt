package com.yetland.alicante.subscribe

abstract class Human<T> {
    companion object {
        fun <T> createMan(creator: HumanCreator<T>): Human<T> {
            return Man(creator)
        }
    }

    fun subscribe(subscribe: Subscribe<T>) {
        subscribeActual(subscribe)
    }

    internal abstract fun subscribeActual(subscribe: Subscribe<T>)
}

class Man<T>(private val creator: HumanCreator<T>) : Human<T>() {
    override fun subscribeActual(subscribe: Subscribe<T>) {
        subscribe.accept(creator.get())
    }
}

interface HumanCreator<T> {
    fun get(): T
}

interface Subscribe<T> {
    fun accept(t: T)
}