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

            do{
            
                String str = in.readLine();
                receive = Integer.parseInt(str);
                System.out.println("numero ricevuto " + receive);

                if(receive > v){
                    out.writeBytes("2\n");
                }
                else if(receive < v){
                    out.writeBytes("1\n");
                }
                else{
                    out.writeBytes("0\n");
                }

            }while(receive != v);        

            s.close();
        }
        catch(Exception e){

            System.out.println(e.getMessage());
            System.exit(1);


        }
        





    }
}
