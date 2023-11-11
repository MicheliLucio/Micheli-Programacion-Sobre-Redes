package Utiles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

public class Desconectar {
	private boolean Desconexion;
	private BufferedReader Reader;
	private PrintStream ps;
	private Socket Cliente;
	public Desconectar(boolean Desconexion, BufferedReader Reader, PrintStream ps, Socket Cliente) {
		this.Desconexion = Desconexion;
		this.Reader = Reader;
		this.ps = ps;
		this.Cliente = Cliente;
	}
	
	public void CerrarConexion() {
		Desconexion = true;
		try {
			Reader.close();
			ps.close();
			if(!Cliente.isClosed()) {
				Cliente.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
