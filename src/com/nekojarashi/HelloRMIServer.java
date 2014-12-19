/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nekojarashi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author y-okubo
 */
public class HelloRMIServer implements Hello {

    public HelloRMIServer() {
    }

    /**
     *
     * @return @throws RemoteException
     */
    @Override
    public String sayHello() throws RemoteException {
        return "Hello, RMI World on Java!";
    }

    /**
     * @param args the command line arguments
     * @throws java.rmi.RemoteException
     */
    public static void main(String[] args) throws RemoteException {
        Hello hello = new HelloRMIServer();
        Registry registry = LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
        Remote remote = UnicastRemoteObject.exportObject(hello, 0);
        registry.rebind("hello", remote);
    }

}
