package com.yetland.alicante.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class Proxy {

    public static void main(String[] args) {
        Callback<String> stringCallback = response -> {
            for (String s : response.t) {
                System.out.println(s);
            }
        };
        Day day = new ProxyTest().create(Day.class);
        day.morning("morning").execute(stringCallback);
        day.afternoon("afternoon").execute(stringCallback);
        day.evening("evening").execute(stringCallback);
    }

    interface Day {
        Call<String> morning(String name);

        Call<String> afternoon(String name);

        Call<String> evening(String name);
    }

    static class Worker<T> implements Call<T> {

        T[] t;

        @Override
        public void execute(Callback<T> callback) {
            Response<T> response = new Response<>();
            response.t = t;
            callback.callback(response);
        }
    }

    interface Call<T> {
        void execute(Callback<T> callback);
    }

    interface Callback<T> {
        void callback(Response<T> response);
    }

    static class Response<T> {
        T[] t;
    }

    static class ProxyTest implements InvocationHandler {

        <T> T create(Class<T> clazz) {
            return (T) java.lang.reflect.Proxy.newProxyInstance(clazz.getClassLoader(),
                    new Class<?>[]{clazz}, this);
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) {
            Worker<Object> worker = new Worker<>();
            worker.t = args;
            return worker;
        }
    }

}
