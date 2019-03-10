package com.example.demo.singleton.lazy;

/**
 *
 *  create by clb at 2019年03月10日17:01:03
 */
public class LazySimpleSingleton {
    private LazySimpleSingleton() {}
    public static  LazySimpleSingleton hungrySingleton = null;
    public static LazySimpleSingleton getInstance (){
        if(hungrySingleton == null) {
            hungrySingleton = new LazySimpleSingleton();
        }
        return hungrySingleton;
    }

}
