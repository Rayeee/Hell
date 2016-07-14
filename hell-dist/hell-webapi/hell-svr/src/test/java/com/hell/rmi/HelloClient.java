package com.hell.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * Created by Rayee on 16/4/21.
 */
public class HelloClient {
    public static void main(String[] args) {
        try {
            IHello hello = (IHello) Naming.lookup("rmi://localhost:8888/IHello");
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
