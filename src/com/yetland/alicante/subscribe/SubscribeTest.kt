package com.yetland.alicante.subscribe

import io.reactivex.*
import org.reactivestreams.Subscriber
import org.reactivestreams.Subscription
import java.text.MessageFormat
import java.util.concurrent.TimeUnit


object SubscribeTest {

    @JvmStatic
    fun main(args: Array<String>) {

        println(MessageFormat.format("哈哈{0}", 3))
        Single.create(SingleOnSubscribe<String> { e -> e.onSuccess("2333") })
                .doOnSuccess {
                    println("---------$it ")
                }
                .subscribe({
                    println("---------$it ")
                }, {
                    println("---------$it ")
                })


        Single.create(SingleOnSubscribe<String> {
            it.onSuccess("哈哈哈")
        }).delay(3000, TimeUnit.MILLISECONDS)
                .subscribe({
                    println(it)
                }, {

                })
        Human.createMan(object : HumanCreator<String> {
            override fun get(): String {
                return "哈哈哈"
            }
        }).subscribe(object : Subscribe<String> {
            override fun accept(t: String) {
                println(t)
            }
        })

        var mSubscription: Subscription
        Flowable.create(FlowableOnSubscribe<Int> { emitter ->
            println("First requested = " + emitter.requested())
            var flag: Boolean
            var i = 0
            while (true) {
                flag = false
                while (emitter.requested() == 0L) {
                    if (!flag) {
                        println("can't emit value !")
                        flag = true
                    }
                }
                emitter.onNext(i)
                println("emit " + i + " , requested = " + emitter.requested())
                i++
            }
        }, BackpressureStrategy.ERROR)
                .subscribe(object : Subscriber<Int> {

                    override fun onSubscribe(s: Subscription) {
                        println("onSubscribe")
                        mSubscription = s
                        mSubscription.request(3)
                    }

                    override fun onNext(integer: Int?) {
                        println("onNext: " + integer!!)
                    }

                    override fun onError(t: Throwable) {
                        println("onError: $t")
                    }

                    override fun onComplete() {
                        println("onComplete")
                    }
                })
    }
}