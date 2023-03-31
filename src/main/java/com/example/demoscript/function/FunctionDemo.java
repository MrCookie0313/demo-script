package com.example.demoscript.function;

import org.bouncycastle.crypto.params.CramerShoupParameters;

import java.util.function.*;

public class FunctionDemo {

    public static void main(String[] args) {
        //断言型
        predicate();
        //消费型
        consumer();
        //一元函数 输入输出不同
        function();
        //提供型
        supplier();
        //一元函数 输入输出类型相同
        unaryOperator();
        //二元函数 输入输出不同
        biFunction();
        //二元函数 输入输出相同
        binaryOperator();
    }

    /**
     *
     */
    public static void predicate() {
        Predicate<Integer> predicate = i -> i > 0;
        IntPredicate intPredicate = i -> i > 0;
        System.out.println(predicate.test(6));
        System.out.println(intPredicate.test(-1));
    }

    public static void consumer() {
        Consumer<String> consumer = s -> System.out.println("hello"+s);
        consumer.accept("我是一个消费者");
    }

    public static void function() {
        Function<Integer, String> function = x -> "数字是：" + x;
        System.out.println(function.apply(88));
    }

    public static void supplier() {
        Supplier<String> supplier = () -> "我是一个提供者";
        System.out.println(supplier.get());
    }

    public static void unaryOperator() {
        UnaryOperator<Integer> unaryOperator = x -> ++x;
        System.out.println(unaryOperator.apply(1));
    }

    public static void biFunction() {
        BiFunction<Integer, Double, Double> biFunction = (x, y) -> {
            ++x;
            ++y;
            return x + y;
        };
        System.out.println(biFunction.apply(1, 2.3));
    }

    public static void binaryOperator() {

        IntBinaryOperator intBinaryOperator = (x, y) -> x + y;
        System.out.println(intBinaryOperator.applyAsInt(2, 3));
    }
}
