package com.example.demoscript.designmode.lsp;

import java.util.*;

/**
 * @Author: sunBing
 * @CreateTime: 2023-03-16  11:41
 * @Description: TODO
 * @Version: 1.0
 */
public class Son extends Father {

    public Collection doSomething(Map map) {
        System.out.println("子类被执行了。。。");
        return map.values();
    }

}
