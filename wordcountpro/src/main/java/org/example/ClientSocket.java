package org.example;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ClientSocket {
    public static void main(String[] args) throws Exception{
        Scanner sc=new Scanner(System.in);
        try{
            Socket s=new Socket("localhost",1212);
            DataOutput dout=new DataOutputStream(s.getOutputStream());
            for(int i=0;i<10;i++){
                String str=sc.nextLine();
                dout.writeUTF(str);
            }


            s.close();
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
