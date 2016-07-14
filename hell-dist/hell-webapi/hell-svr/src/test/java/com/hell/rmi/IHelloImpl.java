package com.hell.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by Rayee on 16/4/21.
 */
public class IHelloImpl extends UnicastRemoteObject implements IHello{

    public IHelloImpl() throws RemoteException {
    }

    @Override
    public String helloWorld() throws RemoteException {
        return "hello world";
    }

    @Override
    public String say(String target) throws RuntimeException {
        return "hello" + target;
    }

}
