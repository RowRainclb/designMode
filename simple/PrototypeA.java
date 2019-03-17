package com.example.demo.prototype.simple;

import java.util.List;

public class PrototypeA implements Prototype{

    private String name;
    private int age;
    private List hobbis;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List getHobbis() {
        return hobbis;
    }

    public void setHobbis(List hobbis) {
        this.hobbis = hobbis;
    }

    @Override
    public Prototype clone() {
        PrototypeA prototypeA = new PrototypeA();
        prototypeA.setAge(this.age);
        prototypeA.setName(this.name);
        prototypeA.setHobbis(this.hobbis);
        return prototypeA;
    }
}
