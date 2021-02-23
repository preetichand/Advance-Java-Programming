package Practical4;
import java.io.*;
import java.net.*;

public class Client {
    
   
    public static void main(String [] args){
        try {
            Socket s=new Socket("192.168.42.100",8081);//make a connection with the server

            InputStreamReader stream1=new InputStreamReader(System.in);//make an inputstreamreader chained to the System input(Keyboard)
            DataInputStream stream2=new DataInputStream(s.getInputStream());   //make a reader chained to the socket's low-level input stream

            BufferedReader reader=new BufferedReader(stream1);   //make a reader chained to InputStreamReader
            DataOutputStream writer=new DataOutputStream(s.getOutputStream());

            String message="",str="";
            while(!message.equals("bye")){
                message=reader.readLine();
                writer.writeUTF(message);
                writer.flush();
                str=stream2.readUTF();
                System.out.println("Server Says :"+str);
            }
            stream2.close();
            s.close();
        } catch (Exception e) {
           e.printStackTrace();
        }

    }


    
}
