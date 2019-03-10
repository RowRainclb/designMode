package com.example.demo.factory.simple;

import com.example.demo.factory.product.Computer;

/**
 * cuilb
 * created by cuilb
 */
public class SimpleFactoryTest {
    public static void main(String[] args) {
        SimpleFactory simpleFactory = new SimpleFactory();
        Computer mac = simpleFactory.getComputerByName("mac");
        Computer thinkpad = simpleFactory.getComputerByName("thinkpad");


    }
}
