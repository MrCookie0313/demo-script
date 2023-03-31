package com.example.demoscript.function;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 * @Author: sunBing
 * @CreateTime: 2023-03-23  15:58
 * @Description: TODO
 * @Version: 1.0
 */
public class ConsumerDemo {
    public static void main(String[] args) {
        //1：平平无奇：直接创建接口并重载
        Consumer<String> consumer1 = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        Stream<String> stream1 = Stream.of("spring", "summer", "autumn", "winter");
        stream1.forEach(consumer1);
        System.out.println("********************");

        //2：偶有起色： 使用Java8另外一个特性，方法引用
        Consumer consumer2 = System.out::println;
        Stream<String> stream2 = Stream.of("spring", "summer", "autumn", "winter");
        stream2.forEach(consumer2);
        System.out.println("********************");

        //3：精彩绝伦，使用lambda表达式
        Consumer<String> consumer3 = s -> System.out.println(s);
        //lambda表达式返回的就是一个Consumer接口
        Stream<String> stream3 = Stream.of("spring", "summer", "autumn", "winter");
        stream3.forEach(consumer3);

        List<Integer> list= Arrays.asList(1,2,3,4,5);
        list.stream().forEach(System.out::println);


    }
}
