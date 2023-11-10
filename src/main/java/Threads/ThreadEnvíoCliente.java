package Threads;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import Utiles.readerClass;

public class ThreadEnvíoCliente extends Thread{
	PrintStream ps = new PrintStream(System.out);
	readerClass lector = new readerClass();
	
	public ThreadEnvíoCliente() {
		
	}
	public void run(DataOutputStream dosCli, DataInputStream disCli) {
		while(true) {
			ps.println("enviar mensaje: ");
			try {
				dosCli.writeUTF(lector.leer());
				dosCli.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
}
