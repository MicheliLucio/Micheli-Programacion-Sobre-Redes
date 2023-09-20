package Socket;
import java.net.InetAddress;
import java.net.MulticastSocket;


public class Recibe {
	public static void main(String[] args) {
		
		PrintStream ps = new PrintStream(System.out);
		
		int port = 5050;
		String IP = "230.1.1.1";
		MulticastSocket socket = null;
		InetAddress IPaddress;
		
		try {
			IPaddress = InetAddress.getByName(IP);
			socket.joinGroup(IPaddress);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ps.println( "Esperando conexion multicast:"
				+ socket.getLocalSocketAddress() 
		);
		
		
		
		
		
	}
}