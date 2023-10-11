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
        ServerSocket Server;
        Socket s;
        BufferedReader in;
        DataOutputStream out; 
        try{

            System.out.println("server in esecuzione");
            Server = new ServerSocket(3000);
            s = Server.accept();
            
            in = new BufferedReader (new InputStreamReader (s.getInputStream()));
            out  = new DataOutputStream(s.getOutputStream());

            String receive = in.readLine();
            String send = receive.toUpperCase();
            out.writeBytes( send + "\n");

            s.close();
        }
        catch(Exception e){

            System.out.println(e.getMessage());
            System.out.println(e.getMessage());
            System.exit(1);


        }
        





    }
}
