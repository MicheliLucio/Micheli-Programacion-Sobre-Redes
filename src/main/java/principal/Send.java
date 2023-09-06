package principal;

import java.net.DatagramSocket;
import java.net.InetAddress;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Send {
	
	//udp
	//MultiCast
	public static void main(){
		try {
			int port = 5050;
			//Rango del multicast
			//224.0.0.0 y 239.255.255.255
			String IP = "230.1.1.1";
			
			
			DatagramSocket udpSocket = new DatagramSocket();
			
			byte[] msg = ("Holaa").getBytes();
			DatagramPacket pack = new DatagramPacket(msg, msg.length);
			
			try {
				InetAddress IPaddress = InetAddress.getByName(IP);
				
				pack.setAddress(IPaddress);
				pack.setPort( port );
				System.out.println();
				System.out.println();
			} catch (UnknownHostException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			

			
			try {
				udpSocket.send( pack );
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}catch(SocketException e) {
			e.printStackTrace();
		}
		
	}
	
}
