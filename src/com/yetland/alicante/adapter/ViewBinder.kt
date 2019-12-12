package com.yetland.alicante.adapter

/**
 * @author: YETLAND
 * @create: 2019-11-28 13:52
 **/
abstract class ViewBinder<T> {
    abstract fun onBindViewHolder(item: T)
}