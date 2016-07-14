package com.hell.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by Rayee on 16/4/21.
 */
public interface IHello extends Remote{

    String helloWorld() throws RemoteException;

    String say(String target) throws RuntimeException;
}
