package com.yetland.alicante.adapter

/**
 * @author: YETLAND
 * @create: 2019-11-28 13:50
 **/
class MultiTypeAdapter {
    private val typePool: TypePool = TypePoolFactory()
    val list: MutableList<Any> = mutableListOf()
    fun onCreateViewHolder() {
        list.forEachIndexed { index, _ ->
            onBindViewHolder(index)
        }
    }

    private fun onBindViewHolder(position: Int) {
        val item = list[position]
        val index = typePool.firstIndexOf(item::class.java)
        val binder = typePool.getViewBinders()[index]
        binder.onBindViewHolder(item)
    }


    fun <T> register(
            clazz: Class<T>,
            viewBinder: ViewBinder<T>
    ) {
        typePool.register(clazz, viewBinder)
    }

}