package com.hell.jdk;

/**
 * Created by Rayee on 16/11/19.
 */
public class GreetingServiceImpl implements GreetingService{
    @Override
    public void say() {
        speak();
    }

    @Override
    public void speak() {
        System.out.println("impl speak 456!");
    }

    public static void main(String[] args) {
        GreetingService service = new GreetingServiceImpl();
        service.say();
    }

}
