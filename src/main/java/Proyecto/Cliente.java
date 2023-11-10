package Proyecto;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import Threads.ThreadEscuchaCliente;
import Threads.ThreadEnvíoCliente;

public class Cliente extends conexion{

	DataInputStream disCli = null;
	ThreadEscuchaCliente escucha = new ThreadEscuchaCliente();
	ThreadEnvíoCliente envio = new ThreadEnvíoCliente();
	
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
			
			
			envio.run(dosCli, disCli); 
			escucha.run(disCli);
			

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
