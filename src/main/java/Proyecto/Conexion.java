package Proyecto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Random;

import Utiles.EscribirYColores;


public class Conexion extends Thread{
	private Socket Cliente;
	private BufferedReader Reader;
	private PrintStream ps;
	private String nickname;
	private EscribirYColores EYC;
	private Random Random;
	private String ColorUsuario;
	private Servidor Servidor;
	
	public Conexion(Socket Cliente) {
		this.Cliente = Cliente;
		Random = new Random();
		int numeroRandom = Random.nextInt(4);
		switch(numeroRandom) {
			case 0:
				ColorUsuario = EYC.ANSI_RED;
				break;
			case 1:
				ColorUsuario = EYC.ANSI_PURPLE;
				break;
			case 2:
				ColorUsuario = EYC.ANSI_CYAN;
				break;
			case 3:
				ColorUsuario = EYC.ANSI_BLACK;
				break;
		}
		try {
			ps = new PrintStream(Cliente.getOutputStream(), true);
			Reader = new BufferedReader(new InputStreamReader(Cliente.getInputStream()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void run() {
		Thread Servicio = new Thread(
				new Runnable() {
					public void run() {
							try {
								EYC = new EscribirYColores();
								ps.println(EscribirYColores.ANSI_PURPLE + "Ingresa un nickname: " + EscribirYColores.ANSI_RESET);
								nickname = Reader.readLine();
								EYC.mensaje(EYC.ANSI_BLUE + nickname + EYC.ANSI_GREEN + "Se conecto al servidor" + EYC.ANSI_RESET);
								String msg;
								while((msg = Reader.readLine()) != null) {
									if(msg.startsWith("/nombre")) {
										String[] partir = msg.split("", 2);
										if(partir.length == 2) {
											Servidor.Broadcast(EYC.ANSI_GREEN + nickname + " cambió su nick a "+ partir[1] + EYC.ANSI_RESET);
											EYC.mensaje(EYC.ANSI_GREEN + nickname + " cambió su nick a "+ partir[1] + EYC.ANSI_RESET);
											nickname = partir[1];
											ps.println(EYC.ANSI_YELLOW + "Ahora te llamás: "+nickname+ EYC.ANSI_RESET);
										}else {
											ps.println(EYC.ANSI_RED+"No se cambió tu nombre de usuario. "+ EYC.ANSI_RESET);
										}
									}else if(msg.startsWith("/salir")){
										Servidor.Broadcast(EYC.ANSI_YELLOW + nickname + "se ha desconectado" + EYC.ANSI_RESET);
										ps.println(EYC.ANSI_YELLOW + " Te has desconectado" +EYC.ANSI_RESET);
									}else {
										Servidor.Broadcast(ColorUsuario + nickname + ": "+ msg+ EYC.ANSI_RESET);
									}
								}
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
									}
									});Servicio.start();
						
	}
	
	public void MandarPaquete(String packeteDeTexto) {
		ps.println(packeteDeTexto);
	}
	public void CerrarConexion(){
        try{
        	Reader.close();
        	ps.close();
            if (!Cliente.isClosed()) {
                Cliente.close();
            }
        }catch(IOException e){
        	e.printStackTrace();
        }
	} 
}
