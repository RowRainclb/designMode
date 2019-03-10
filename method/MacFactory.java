package com.example.demo.factory.method;

import com.example.demo.factory.product.Computer;
import com.example.demo.factory.product.Mac;

public class MacFactory implements ComputerFactory {
    @Override
    public Computer createComputer() {
        System.out.printf("create mac");
        return new Mac();
    }
}
