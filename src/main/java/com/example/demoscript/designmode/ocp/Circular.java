package com.example.demoscript.designmode.ocp;

import lombok.Data;

// 圆形
@Data
public class Circular {
    private double radius;

    public double getRadius() {
        return radius;
    }
}