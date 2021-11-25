package com.company;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server extends UnicastRemoteObject implements HelloService{
    public Server() throws RemoteException{
        super();
    }

    public static void main(String[] args) {
        try{
            Registry reg = LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
            Server object = new Server();
            reg.rebind("rmi://localhost/service", object);

            System.out.println("Hey Server bound in registry");
        }catch (RemoteException ex){
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public String echo(String input) throws RemoteException {
        return "Hello" + input;
    }
}
