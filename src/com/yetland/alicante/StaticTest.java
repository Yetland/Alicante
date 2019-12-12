package com.yetland.alicante;

public class StaticTest {

    public static void main(String... args) {
        A a = new SubA();
    }

    public static class A {
        static int a = 4;

        static {
            a++;
            int b = 4;
            System.out.print("alicante = " + a + " , b = " + b);
        }
    }

    public static class SubA extends A {
        static {
            a++;
            int y = 6;
            System.out.print("alicante = " + a + " , y = " + y);
        }
    }
}
