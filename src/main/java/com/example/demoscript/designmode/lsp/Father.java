package com.example.demoscript.designmode.lsp;

import java.util.*;

/**
 * @Author: sunBing
 * @CreateTime: 2023-03-16  11:39
 * @Description: TODO
 * @Version: 1.0
 */
public class Father {
    public Collection doSomething(HashMap map) {
        System.out.println("父类被执行了。。。");
        return map.values();
    }

}
