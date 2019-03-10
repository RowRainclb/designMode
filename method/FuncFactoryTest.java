package com.example.demo.factory.method;

public class FuncFactoryTest {
    public static void main(String[] args) {
        ComputerFactory macFactory = new MacFactory();
        macFactory.createComputer();
        ComputerFactory thinkpadFactory = new ThinkpadFactory();
        thinkpadFactory.createComputer();
    }
}
