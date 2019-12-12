package com.yetland.alicante.generic

object GenericTest {

    @JvmStatic
    fun main(args: Array<String>) {
        eat(Meat())
        eatFood(listOf(Meat(), Pork(), Beef(), Fruit()))
    }

    private fun <T : Food> eatFood(list: List<T>) {
        list.forEach {
            eat(it)
        }
    }

    private fun <T : Food> eat(t: T) {
        println("eat ${t.name}")
    }

    open class Food {
        open var name: String? = null
    }

    open class Meat : Food() {
        override var name: String? = null
            get() = "Meat"
    }

    class Pork : Meat() {
        override var name: String? = null
            get() = "Pork"
    }

    class Beef : Meat() {
        override var name: String? = null
            get() = "Beef"
    }

    open class Fruit : Food() {
        override var name: String? = null
            get() = "fruit"
    }

    class Apple : Fruit() {
        override var name: String? = null
            get() = "Apple"
    }

    class Orange : Fruit() {
        override var name: String? = null
            get() = "Apple"
    }
}