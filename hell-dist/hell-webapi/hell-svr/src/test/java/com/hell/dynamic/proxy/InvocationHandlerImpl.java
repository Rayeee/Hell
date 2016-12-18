package com.hell.dynamic.proxy;

import com.hell.dynamic.impl.ElectricCar;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by Rayee on 16/12/18.
 */
public class InvocationHandlerImpl implements InvocationHandler {

    private ElectricCar car;

    public InvocationHandlerImpl(ElectricCar car) {
        this.car = car;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("You are going to invoke " + method.getName() + " ...");
        method.invoke(car, null);
        System.out.println(method.getName() + " invocation Has Been finished...");
        return null;
    }

}
