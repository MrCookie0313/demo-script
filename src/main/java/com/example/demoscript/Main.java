package com.example.demoscript;

public class Main {
    private static int times = 3;

    public static void main2(String[] args) {
        times--;
        main(args);
    }

    public static void main(String[] args) {
        System.out.println("main方法执行:" + times);
        if (times <= 0) {
            System.exit(0);
        }
        main2(args);
    }
}