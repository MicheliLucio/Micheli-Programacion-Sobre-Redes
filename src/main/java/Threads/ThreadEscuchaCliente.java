package Threads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import Utiles.Desconectar;

public class ThreadEscuchaCliente extends Thread{
	PrintStream ps = new PrintStream(System.out);
	private BufferedReader Reader;
	boolean Desconexion;
	Desconectar Desconectar;
	
	public ThreadEscuchaCliente(BufferedReader Reader, boolean Desconexion, Desconectar Desconectar) {
		this.Reader = Reader;
		this.Desconexion = Desconexion;
		this.Desconectar = Desconectar;
	}
	public void run() {
		while(!Desconexion)
		{
			try {
				String mensaje = Reader.readLine();
				if(mensaje.equals("/salir")) {
					Reader.close();
					Desconectar.CerrarConexion();
				}else {
					ps.println(mensaje);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
			

		
	}
}
