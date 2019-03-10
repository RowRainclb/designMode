package com.example.demo.singleton.hungry;

public class HungryStaticSingleton {
    private HungryStaticSingleton() {}
    public static final HungryStaticSingleton hungrySingleton ;
    static {
        hungrySingleton = new HungryStaticSingleton();
    }
    public static HungryStaticSingleton getInstance (){
        return hungrySingleton;
    }

}
