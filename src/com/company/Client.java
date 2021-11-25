package com.company;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {

        try{
            Registry reg = LocateRegistry.getRegistry("localhost",1099);
            HelloService server = (HelloService) reg.lookup("rmi://localhost/service");

            System.out.println("Bound to :" + server);

            Scanner scan = new Scanner(System.in);

            System.out.println("Enter your Input");
            String Input = scan.nextLine();

            String response = server.echo(Input);
            System.out.println(response);

        }catch (RemoteException  |NotBoundException e){
            System.out.println(e.getMessage());
        }
    }
}
