package SocketTCP;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class servidor extends conexion {
	
	InputStreamReader isrServ = null;
	BufferedReader read = null;
	public servidor() {
		super("servidor");
	}
	
	public void serverOn() 
	{
		try {
			ps.println("Esperando un cliente ...");
			
			//congela programa
			sock = servSock.accept();
			
			ps.println("IP: "+sock.getInetAddress().getHostAddress() +
					   "\nNombre: " +sock.getInetAddress().getHostName()+
					   "\nPort: "+ sock.getPort() + "\n"
					  );
			dosSer = new DataOutputStream(sock.getOutputStream());
			isrServ = new InputStreamReader(sock.getInputStream());
			read = new BufferedReader( isrServ );
			
			ps.println("Cliente conectado con exito :) !!!");
			
			ps.println("Esperando mensaje del cliente ...");
			
			while((msg = read.readLine()) != null)
			{
				//aca recibi un mensaje seguro
				ps.println( msg );
				
				dosSer.writeUTF("Quiero!");
				dosSer.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			
			
			try {
				sock.close();
				if(read !=null)
				read.close();
				if(isrServ != null)
				isrServ.close();
				dosSer.close();
				servSock.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
