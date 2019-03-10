package com.example.demo.factory.abstrat;

public class AbstFactoryTest {
    public static void main(String[] args) {
        ComputerFactory fuskangFactory = new FuskangFactory();
        fuskangFactory.getMac();
        fuskangFactory.getThinkPad();
        ComputerFactory huaweiFactory = new HuaweiFactory();
        huaweiFactory.getMac();
        huaweiFactory.getThinkPad();
    }
}
