package com.example.demoscript;

import com.google.common.base.CaseFormat;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author: sunBing
 * @CreateTime: 2023-02-01  10:42
 * @Description: TODO
 * @Version: 1.0
 */
public class Test {
    public static void main(String[] args) {
        // 驼峰转下划线
        String ans = CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, "helloWorld");
        System.out.println(ans);
// 下划线转驼峰
        String ans2 = CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, "hello_world");
        System.out.println(ans2);


        List<String> aa = new ArrayList<>();
        aa.add("W3");
        aa.add("T8");
        List<String> bb = new ArrayList<>();
        bb.add("1001");
        bb.add("1002");
        bb.add("T8");
        System.out.println(CollectionUtils.containsAny(aa, bb));
        //当 Collection 对象中不存在公共元素时返回真，否则返回假
        System.out.println(Collections.disjoint(aa, bb));//false


        List<String> list = Arrays.asList("tom", "jame", "jerry", "hello");
        List<String[]> collect = list.stream()
                .map(s -> s.split(""))
                .collect(Collectors.toList());
        System.out.println(collect);
        System.out.println(" ============" );
        List<String> list2 = Arrays.asList("tom", "jame", "jerry", "hello");
        List<String> collect2 = list2.stream().map(s -> s.split("")).flatMap(s -> Arrays.stream(s)).collect(Collectors.toList());
        System.out.println(collect2);

        HashMap<String,Integer> map = new HashMap<>(16);
        map.put("zhangsan",21);
        map.put("lis",23);
        map.put("wuwu",11);
        List<Map.Entry<String, Integer>> collect1 = map.entrySet().stream()
                .filter(t -> t.getValue() > 18)
                .collect(Collectors.toList());

        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());

        Random random = new Random();
        random.ints().filter(e->e>0).limit(10).forEach(System.out::println);

        List<Integer> integers = Arrays.asList(1, 3, 2, 3, 2, 6, 7, 5);
        List<String> collect3 = integers.stream().map(t -> t * t + "").distinct().collect(Collectors.toList());
        System.out.println("collect3 = " + collect3);

    }
}
