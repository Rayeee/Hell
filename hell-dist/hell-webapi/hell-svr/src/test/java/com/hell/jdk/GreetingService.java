package com.hell.jdk;

/**
 * Created by Rayee on 16/11/19.
 */
@FunctionalInterface
public interface GreetingService {

    void say();

    default void speak(){
        System.out.println("speak 123!");
    }

}
