package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class ServerMultiThread extends Thread{
    
    Socket client;

    public ServerMultiThread(Socket c){

        this.client = c;

    }

    public void run(){

        try{

            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            DataOutputStream out = new DataOutputStream(client.getOutputStream());

            int numRandom = (int) (Math.random() * 100) +1;
            System.out.println(numRandom);

            int tentativi = 0;
            int risposta;

            do{
                risposta = Integer.parseInt(in.readLine());
                tentativi++;

                if(risposta < numRandom){

                    out.writeBytes("1\n");

                }

                else if(risposta > numRandom){

                    out.writeBytes("2\n");

                }

                else{
                    out.writeBytes("3\n");
                    out.writeBytes(tentativi + "\n");

                }


            }while(risposta != numRandom);


            client.close();
            

        }catch (Exception e) {
            System.out.println("errore " + e.getMessage());
        }
        



    }







}
