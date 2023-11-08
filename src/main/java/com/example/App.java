package com.example;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ServerSocket Server;
        Socket client;

        try{
            
            Server = new ServerSocket(3000);

            while (true) {
                
                client = Server.accept();
                Thread t = new ServerMultiThread(client);
                t.start();

            }

           
        }
        catch(Exception e){

            System.out.println(e.getMessage());
            System.exit(1);


        }
        





    }
}
