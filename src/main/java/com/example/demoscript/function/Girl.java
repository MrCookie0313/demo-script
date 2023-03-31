package com.example.demoscript.function;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Girl {

    private String name;

    private Double size;

    private Double price;

    public static Girl create(final Supplier<Girl> supplier) {
        return supplier.get();
    }

    public static void main(String[] args) {
    	//创建对象
        Girl girl1 = Girl.create(Girl::new);
        Girl girl2 = Girl.create(()-> new Girl("lily",33d,1700d));
        Girl girl = null;
        //orElseGet
        Girl girl3 = Optional.ofNullable(girl).orElseGet(Girl::new);
        System.out.println("girl3 = " + girl3);

        Supplier<Girl> supplier = ()-> new Girl("lucy",33d,1700d);
        Function<Girl,String> girlMark = (Girl g)-> g.getName()+"的尺寸是"+g.getSize()+"，每次能赚"+g.getPrice()+"。";
        System.out.println(girlMark.apply(supplier.get()));

    }
    
}
