package com.example.demo.factory.abstrat;

import com.example.demo.factory.product.Computer;
import com.example.demo.factory.product.Mac;
import com.example.demo.factory.product.ThinkPad;

public class FuskangFactory implements ComputerFactory {

    @Override
    public Computer getMac() {
        return new Mac();
    }

    @Override
    public Computer getThinkPad() {
        return new ThinkPad();
    }
}
