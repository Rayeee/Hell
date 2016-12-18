package com.hell.dynamic.main;

import com.hell.dynamic.api.Rechargable;
import com.hell.dynamic.api.Vehicle;
import com.hell.dynamic.impl.ElectricCar;
import com.hell.dynamic.proxy.InvocationHandlerImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created by Rayee on 16/12/18.
 */
public class ElectricMainer {

    public static void main(String[] args) {
        ElectricCar car = new ElectricCar();
        ClassLoader classLoader = car.getClass().getClassLoader();
        Class<?>[] interfaces = car.getClass().getInterfaces();
        InvocationHandler handler = new InvocationHandlerImpl(car);
        Object o = Proxy.newProxyInstance(classLoader, interfaces, handler);
        Vehicle vehicle = (Vehicle) o;
        Rechargable rechargable = (Rechargable) o;
        vehicle.drive();
        rechargable.recharge();
    }

}
