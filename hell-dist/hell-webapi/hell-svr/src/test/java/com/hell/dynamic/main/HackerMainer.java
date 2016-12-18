package com.hell.dynamic.main;

import com.hell.dynamic.impl.Programmer;
import com.hell.dynamic.proxy.Hacker;
import org.springframework.cglib.proxy.Enhancer;

/**
 * Created by Rayee on 16/12/18.
 */
public class HackerMainer {

    public static void main(String[] args) {
        Programmer programmer = new Programmer();
        Hacker hacker = new Hacker();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(programmer.getClass());
        enhancer.setCallback(hacker);
        Programmer proxy = (Programmer)enhancer.create();
        proxy.code();
    }

}
