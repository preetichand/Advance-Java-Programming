package Practical5;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Client {
    
    public static void main(String[]args) throws Exception
	{
		Scanner sc= new Scanner(System.in);
		DatagramSocket ds= new DatagramSocket();
		InetAddress ip=InetAddress.getLocalHost();
		byte buf[]=null;
		String inp=sc.nextLine();
		buf=inp.getBytes();
		DatagramPacket dpsend=new DatagramPacket(buf,buf.length,ip,1234);
		ds.send(dpsend);
        ds.close();
        sc.close();
	}

}
