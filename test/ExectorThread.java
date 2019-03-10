package com.example.demo.test;


import com.example.demo.singleton.lazy.LazySimpleSingleton;

/**
 * Created by clb.
 */
public class ExectorThread implements Runnable{
    @Override
    public void run() {

        LazySimpleSingleton singleton = LazySimpleSingleton.getInstance();

//        ThreadLocalSingleton singleton = ThreadLocalSingleton.getInstance();
        System.out.println(Thread.currentThread().getName() + ":" + singleton);
    }
}
