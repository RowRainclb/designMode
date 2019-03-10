package com.example.demo.factory.method;

import com.example.demo.factory.product.Computer;
import com.example.demo.factory.product.ThinkPad;

public class ThinkpadFactory implements ComputerFactory {
    @Override
    public Computer createComputer() {
        System.out.println("create thinkpad");
        return new ThinkPad();
    }
}
