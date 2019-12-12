package com.yetland.alicante.binary;

public class Hello {
    public static void main(String... args) {
        System.out.print("-20 左移：" + (-20 << 2) + "\n");
        System.out.print("10 左移：" + (15 << 2) + "\n");
        System.out.print("15 右移：" + (-15 >> 2) + "\n");
        System.out.print("15 无差别右移：" + (15 >>> 2) + "\n");
        System.out.print("-15 无差别右移：" + (-15 >>> 2) + "\n");
        System.out.print("~：" + ~0 + "\n");
        // 0011
        // 1111

        System.out.print("fff =" + (14 >> 2));
        System.out.print("fff =" + (-14 >> 2));
    }
}
