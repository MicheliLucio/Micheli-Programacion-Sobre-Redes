package Proyecto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import Threads.ThreadEscuchaCliente;
import Utiles.Desconectar;
import Utiles.EscribirYColores;


public class Cliente extends Thread{
	 private Socket Cliente;
	 private ThreadEscuchaCliente hiloEscucha;
	 private InputStreamReader isr;
	 private BufferedReader Reader;
	 private PrintStream ps;
	 private String Direccion = "127.0.0.1";
	 private int Port = 5050;
	 private EscribirYColores EYC;
	 private boolean Desconexion;
	 private Desconectar Desconectar;
	 

	 public Cliente() {
			
		}
	 public void ClienteOn() {
			run();
		}
	 public void run() {
		 try {
			Cliente = new Socket(Direccion, Port);
			isr = new InputStreamReader(Cliente.getInputStream());
			Reader = new BufferedReader(isr);
			ps = new PrintStream(Cliente.getOutputStream());
			EYC = new EscribirYColores();
			Desconectar = new Desconectar(Desconexion, Reader, ps, Cliente);
			hiloEscucha = new ThreadEscuchaCliente(Reader, Desconexion, Desconectar);
			
			hiloEscucha.start();
			
			
			String mensaje;
			
			while((mensaje = Reader.readLine()) != null) {
				EYC.mensaje(mensaje);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	 }
}

	
