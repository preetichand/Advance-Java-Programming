package Practical2;
import java.io.*;
import java.net.*;

public class Server {
    public static void main(String args[]){
      
        try {
            
            ServerSocket ss=new ServerSocket(8081);
            Socket s= ss.accept();
            
            System.out.println("Connection is stable");
            InputStreamReader stream1=new InputStreamReader(System.in);
            DataInputStream stream2= new  DataInputStream(s.getInputStream());

            BufferedReader reader =new BufferedReader(stream1);
            DataOutputStream writer = new DataOutputStream(s.getOutputStream());

            String message="",str="";
            while(!str.equals("bye")){
                message=stream2.readUTF();
                System.out.println("Client says :"+message);
                
                str=reader.readLine();
                writer.writeUTF(str);
                writer.flush();
            }
        
            s.close();
            ss.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
       
    }
}
