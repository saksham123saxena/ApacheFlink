package org.example;

import java.io.DataInputStream;
import java.net.Socket;

public class ServerSocket {
    public static void main(String[] args) {
        try{
            System.out.println("Hello, Server Side!");
            java.net.ServerSocket ss=new java.net.ServerSocket(1212);
            Socket s=ss.accept();
            DataInputStream dis=new DataInputStream(s.getInputStream());
            System.out.println("Enter the input stream");
            String input= dis.readUTF();
            System.out.println("message: "+input);
            ss.close();

        }catch (Exception e){
            System.out.println(e);
        }
    }
}
