package SocketTCP;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class cliente extends conexion{
	
	InputStreamReader isrCli = null;
	BufferedReader read = null;
	
	public cliente() {
		super("cliente");
	}
	public void clienteOn() 
	{
		
		try {
			sock = new Socket(getIP() , 5050);
			
			ps.println("IP: "+sock.getInetAddress().getHostAddress() +
					   "Nombre: " +sock.getInetAddress().getHostName()+
					   "Port: "+ sock.getPort() + "\n"
					  );
			
			dosCli = new DataOutputStream(sock.getOutputStream());
			isrCli = new InputStreamReader(sock.getInputStream());
			read = new BufferedReader(isrCli);
			
			dosCli.writeUTF("truco");
			dosCli.flush();
			
			while((msg = read.readLine()) != null) 
			{
				ps.println("nos canto retrucooo x.x");
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}finally {
			
			
			try {
				sock.close();
				if(read !=null)
				read.close();
				if(isrCli != null)
				isrCli.close();
				dosSer.close();
				servSock.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
}
