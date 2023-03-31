package com.example.demoscript.designmode;

/**
 * @Author: sunBing
 * @CreateTime: 2023-03-15  14:13
 * @Description: TODO
 * @Version: 1.0
 */ //子类狗实现抽象方法
public class Dog extends AniMal {

    @Override
    void ObjectX() {
        System.out.println("dog");
    }

    void defaultMethod() {
        System.out.println("12-hello world");
    }
}
