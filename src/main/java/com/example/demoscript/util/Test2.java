package com.example.demoscript.util;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

import java.math.BigDecimal;

/**
 * @Author: sunBing
 * @CreateTime: 2023-03-13  20:32
 * @Description: TODO
 * @Version: 1.0
 */
public class Test2 {
    public static void main(String[] args) {
        // 开始时间
        long startTime = System.currentTimeMillis();
        // 初始化误判个数
        BigDecimal count = new BigDecimal("0");
        // 相当于一个常量
        BigDecimal one = new BigDecimal("1");
        // 测试的10W个数据 也是常量 用于计算误判率
        BigDecimal testCount = new BigDecimal("100000");
        // 百分比换算，还是常量
        BigDecimal mult = new BigDecimal("100");

        // 第一个参数为数据类型，第二个数组长度，第三个误判率
        BloomFilter<Integer> bloomFilter = BloomFilter.create(Funnels.integerFunnel(), 1000000L, 0.01);

        // 插入100w个数据
        for (int i = 1; i <= 1000000; i++) {
            bloomFilter.put(i);
        }

        // 测试10W个不存在的数据
        for (int i = 2000000; i <= 2100000; i++) {
            boolean mightContain = bloomFilter.mightContain(i);
            if (mightContain) {
                count = count.add(one);
            }
        }
        System.out.println("总耗时" + (System.currentTimeMillis() - startTime) + "MS");
        System.out.println("误判个数:" + count);
        System.out.println("误判率:" + (count.divide(testCount)).multiply(mult) + "%");

    }
}
