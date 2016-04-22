package com.hell.rmi;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 * Created by Rayee on 16/4/21.
 */
public class HelloServer {
    public static void main(String[] args) {
        try {
            IHello hello = new IHelloImpl();
            LocateRegistry.createRegistry(8888);
            Naming.bind("rmi://localhost:8888/IHello", hello);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (AlreadyBoundException e) {
            e.printStackTrace();
        }
    }
}
