package com.yetland.alicante.generic;

public class Chef {
    public <F extends Food> Food cook(F... f) {
        return Food.make(f);
    }

    public <M extends Meat> Food cookMeat(M... m) {
        return Food.make(m);
    }

    public static class MeatChef<T> extends Chef {
        public void cook2(T t){

        }
    }
}
