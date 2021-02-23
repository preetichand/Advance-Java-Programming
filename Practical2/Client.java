package Practical2;

import java.io.*;
import java.net.*;

public class Client {
    public static void main(String []args){
        try{
            Socket s=new Socket("192.168.42.100",8080);
            DataOutputStream dout=new 
            DataOutputStream(s.getOutputStream());
            dout.writeUTF("Hello Server,This is Preeti Chand !");

            dout.flush();
            dout.close();
            s.close();
            

        }catch(Exception e){
            System.out.println(e);
        }
    }
}