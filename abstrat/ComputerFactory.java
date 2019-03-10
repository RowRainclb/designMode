package com.example.demo.factory.abstrat;

import com.example.demo.factory.product.Computer;

public interface ComputerFactory {
    public Computer getMac();
    public Computer getThinkPad();

}
