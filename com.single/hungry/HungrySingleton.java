package com.example.demo.singleton.hungry;

/**
 *
 *  浪费内存空间
 */
public class HungrySingleton {
    private HungrySingleton() {}
    public static final HungrySingleton hungrySingleton = new HungrySingleton();
    public static HungrySingleton getInstance (){
        return hungrySingleton;
    }

}
