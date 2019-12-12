package com.yetland.alicante.adapter


object Test {
    @JvmStatic
    fun main(args: Array<String>) {
        val adapter = MultiTypeAdapter()
        adapter.register(Bean::class.java, B())
        adapter.register(ABean::class.java, A())
        adapter.list.add(Bean("James"))
        adapter.list.add(ABean(34))
        adapter.list.add(Bean("Kobe"))
        adapter.list.add(Bean("Irving"))
        adapter.list.add(ABean(36))
        adapter.list.add(Bean("Curry"))
        adapter.list.add(ABean(36))
        adapter.list.add(Bean("Harden"))
        adapter.list.add(ABean(36))
        adapter.onCreateViewHolder()

    }

    data class Bean(val name: String)
    class B : ViewBinder<Bean>() {
        override fun onBindViewHolder(item: Bean) {
            println(item.toString())
        }
    }

    data class ABean(val age: Int)
    class A : ViewBinder<ABean>() {
        override fun onBindViewHolder(item: ABean) {
            println(item.toString())
        }
    }
}