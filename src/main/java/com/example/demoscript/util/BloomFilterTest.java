package com.example.demoscript.util;

import com.google.common.base.Charsets;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

/**
 * Guava版布隆过滤器
 */
public class BloomFilterTest {

    /**
     * @param expectedInsertions 预期插入值
     *                           这个值的设置相当重要，如果设置的过小很容易导致饱和而导致误报率急剧上升，如果设置的过大，也会对内存造成浪费，所以要根据实际情况来定
     * @param fpp                误差率，例如：0.001,表示误差率为0.1%
     * @return 返回true，表示可能存在，返回false一定不存在
     */
    public static boolean isExist(int expectedInsertions, double fpp) {
        // 创建布隆过滤器对象
        BloomFilter<Integer> filter = BloomFilter.create(Funnels.integerFunnel(), expectedInsertions, 0.01);

        // 判断指定元素是否存在
        System.out.println(filter.mightContain(10));

        // 将元素添加进布隆过滤器
        filter.put(10);

        // 再判断指定元素是否存在
        System.out.println(filter.mightContain(10));
        return filter.mightContain(10);
    }

    //主类中进行测试
    public static void main(String[] args) {
        /**
         *  expectedInsertions 预期插入值
         *  这个值的设置相当重要，如果设置的过小很容易导致饱和而导致误报率急剧上升，如果设置的过大，也会对内存造成浪费，所以要根据实际情况来定
         *  fpp                误差率，例如：0.01,表示误差率为1%
         */
        int expectedInsertions = 100_0000;//期望插入的数据量
        double fpp = 0.01; //误判率

        // 创建布隆过滤器对象
        BloomFilter<Integer> filter = BloomFilter.create(Funnels.integerFunnel(), expectedInsertions, fpp);
        BloomFilter<Long> filter2 = BloomFilter.create(Funnels.longFunnel(), expectedInsertions, fpp);
        BloomFilter<String> filter3 = BloomFilter.create(Funnels.stringFunnel(Charsets.UTF_8), expectedInsertions, fpp);
        System.out.println("------------未插入数据前检测-----------");
        for (int i = 89_9990; i < 90_0003; i++) {
            // 判断指定元素是否存在
            System.out.println(i + " 是否存在: " + filter.mightContain(i));
        }

        long s1 = System.currentTimeMillis();
        for (int i = 0; i < 90_0000; i++) {//向过滤器添加90万数据
            // 将元素添加进布隆过滤器
            filter.put(i);
        }
        System.out.println("添加90_0000条数据耗时:" + (System.currentTimeMillis() - s1) + " ms");

        System.out.println("------------插入数据后检测-----------");
        long s2 = System.currentTimeMillis();
        for (int i = 89_9990; i < 90_0009; i++) {
            // 判断指定元素是否存在
            System.out.println(i + " 是否存在: " + filter.mightContain(i));
        }
        System.out.println("检测耗时:" + (System.currentTimeMillis() - s2) + " ms");
    }
}