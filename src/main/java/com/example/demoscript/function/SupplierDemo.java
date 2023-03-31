package com.example.demoscript.function;

import java.util.Random;
import java.util.function.Supplier;

/**
 * @Author: sunBing
 * @CreateTime: 2023-03-23  16:20
 * @Description: TODO
 * @Version: 1.0
 */
public class SupplierDemo {
    public static void main(String[] args) {
//1: 直接新建一个Supplier接口
        Supplier<Integer> supplier = new Supplier<Integer>() {
            @Override
            public Integer get() {
                //返回一个随机值
                return new Random().nextInt();
            }
        };
        System.out.println(supplier.get());
        System.out.println("********************");

        Supplier<Double> supplier2 = Math::random;
        System.out.println(supplier2.get());
        System.out.println("********************");

        supplier = () -> new Random().nextInt();
        System.out.println(supplier.get());

    }
}
