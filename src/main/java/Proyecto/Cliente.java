package Proyecto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import Utiles.EscribirYColores;



public class Cliente extends Thread{
	 private Socket Cliente;
	 private BufferedReader Reader;
	 private InputStreamReader isr;
	 private PrintStream ps;
	 private boolean Desconexion;
	 private String Direccion = "127.0.0.1";
	 private int Port = 5050;
	 private EscribirYColores EYC;
	 
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
			
			Thread hiloEscucha = new Thread( new Runnable() {
				public void run() {
					while(!Desconexion)
					{
						try {
			                BufferedReader Reader = new BufferedReader(new InputStreamReader(System.in));
			                while (!Desconexion) {                    
			                    String mensaje = Reader.readLine();
			                    if (mensaje.equals("/salir")) {
			                    	Reader.close();
			                    	CerrarConexion();
			                    }else{
			                    	ps.println(mensaje);
			                    }
			                }
			            } catch (IOException e) {
			            	CerrarConexion();
			            }
					}
				}
			});
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
	 public void CerrarConexion() {
			Desconexion = true;
	        try {
	        	Reader.close();
	        	ps.close();
	            if (!Cliente.isClosed()) {
	                Cliente.close();
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		}
}

	
