package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
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
    
        try{

            System.out.println("server in esecuzione");
            ServerSocket Server = new ServerSocket(3344);
            Socket s = Server.accept();
            
            BufferedReader in = new BufferedReader (new InputStreamReader (s.getInputStream()));
            DataOutputStream out  = new DataOutputStream(s.getOutputStream());

            String receive = in.readLine();
            String send = receive.toUpperCase();
            out.writeBytes( send + "\n");


        }
        catch(Exception e){

            System.out.println(e.getMessage());
            System.out.println(e.getMessage());
            System.exit(1);


        }
        





    }
}
