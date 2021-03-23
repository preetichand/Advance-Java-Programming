package Practical5;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Server {
    
    public static void main(String[] args)throws Exception
	{
		DatagramSocket ds =new DatagramSocket(1234);
		byte[] receive=new byte[65536];
		DatagramPacket dp=null;
		dp=new DatagramPacket(receive,receive.length);
		ds.receive(dp);
		String str=data(receive).toString();
		InetAddress ip=InetAddress.getByName(str);
		System.out.println("Host Address:-" +ip.getHostAddress());
        ds.close();
	}
	public static StringBuilder data(byte[]a)
	{
		if(a==null)
		{
			return null;
		}
		StringBuilder ret=new StringBuilder();
		int i=0;
		while(a[i]!=0)
		{
			ret.append((char)a[i]);
			i++;
		}
		return ret;
	}

}
