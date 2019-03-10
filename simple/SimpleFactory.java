package com.example.demo.factory.simple;

import com.example.demo.factory.product.Computer;
import com.example.demo.factory.product.Mac;
import com.example.demo.factory.product.ThinkPad;

public class SimpleFactory {

    public Computer getComputerByName(String name){
        if("mac".equals(name)){
            System.out.println("create mac");
            return new Mac();
        } else if("thinkpad".equals(name)){
            System.out.println("create thinkpad");
            return new ThinkPad();
        }
        return null;
    }
}
