package com.example.demoscript.designmode.ocp;

import lombok.Data;

// 矩形
@Data
public class Rectangle {
    private double width;

    private double height;

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

}