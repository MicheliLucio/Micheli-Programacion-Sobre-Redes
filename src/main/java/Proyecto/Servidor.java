package Proyecto;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import Utiles.readerClass;
import Threads.ThreadEscuchaServidor;

public class Servidor extends conexion {
	DataInputStream disSer = null;
	readerClass rSer = null;
	ThreadEscuchaServidor hiloSer = new ThreadEscuchaServidor();
	
	public Servidor() {
		super("servidor");
		// TODO Auto-generated constructor stub
	}
	
	@SuppressWarnings("deprecation")
	public void serverOn() {
		try {
			// Crear un thread para esta accion
			ps.println("Esperando a un cliente ...");
			
			sock = servSock.accept();
			ps.println(
					"IP: " + sock.getInetAddress().getHostAddress() + "\nNombre: " + sock.getInetAddress().getHostName()
							+ "\nPort: " + sock.getPort() + "\nPort Local: " + sock.getLocalPort() + "\n");

			dosSer = new DataOutputStream(sock.getOutputStream());
			disSer = new DataInputStream( sock.getInputStream());

			ps.println("Cliente conectado con exito :) !!!");
			ps.println("Esperando mensaje del cliente ..." );

			// crear otro thread para esto
			hiloSer.run(disSer,dosSer);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				sock.close();
				
				if (disSer != null)
					disSer.close();

				dosSer.close();
				servSock.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
