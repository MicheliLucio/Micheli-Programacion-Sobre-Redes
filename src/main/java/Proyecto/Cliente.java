package Proyecto;


import java.io.DataInputStream;
import Utiles.readerClass;
import java.io.DataOutputStream;
import java.io.IOException;


public class Cliente extends conexion{

	DataInputStream disCli = null;
	readerClass lector = new readerClass();
	
	public Cliente() {
		super("cliente");
		// TODO Auto-generated constructor stub
	}

	public void clienteOn() {
		try {

			ps.println("IP: " + sock.getInetAddress().getHostAddress() + 
					"\nNombre: " + sock.getInetAddress().getHostName() + 
					"\nPort: " + sock.getPort()  + 
					"\nPort Local: " + sock.getLocalPort() +
					"\n"
					);

			dosCli = new DataOutputStream(sock.getOutputStream());
			disCli = new DataInputStream(sock.getInputStream());

			ps.println("enviando mensaje");
			dosCli.writeUTF(lector.leer());
			dosCli.flush();
			
			//crear un thread para esto
			while (true) {
				msg = disCli.readUTF();
				ps.println("--" + msg);
				if(msg.equals("REEE TRUCO"))
					ps.println("\tnos canto retrucooo x.x");
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				sock.close();
				disCli.close();
				dosSer.close();
				servSock.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
