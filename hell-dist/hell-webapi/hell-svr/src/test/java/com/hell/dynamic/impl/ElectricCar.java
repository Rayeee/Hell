package com.hell.dynamic.impl;

import com.hell.dynamic.api.Rechargable;
import com.hell.dynamic.api.Vehicle;

/**
 * Created by Rayee on 16/12/18.
 */
public class ElectricCar implements Rechargable, Vehicle{

    @Override
    public void drive() {
        System.out.println("Electric Car is Moving silently...");
    }

    @Override
    public void recharge() {
        System.out.println("Electric Car is Recharging...");
    }
}
