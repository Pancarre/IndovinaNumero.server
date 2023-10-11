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
        int v ;
        int receive = 4;
        try{
            v = (int)(Math.random()*100)+1;

            
            Server = new ServerSocket(3000);
            System.out.println("server in esecuzione");
            System.out.println("numero casuale " + v);
            s = Server.accept();
            
            in = new BufferedReader (new InputStreamReader (s.getInputStream()));
            out  = new DataOutputStream(s.getOutputStream());



            while(receive != 0){

                receive = in.read();
                System.out.println("numero casuale " + receive);

            
                if(receive > v){

                    out.writeInt(2);

                }
                else if(receive < v){

                    out.writeInt(1);

                }
                else{

                    out.writeInt(0);

                }

            }
            

            s.close();
        }
        catch(Exception e){

            System.out.println(e.getMessage());
            System.exit(1);


        }
        





    }
}
