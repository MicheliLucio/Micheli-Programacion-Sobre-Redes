package Threads;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.DataOutputStream;

public class ThreadEscuchaServidor extends Thread{
	
	PrintStream ps = new PrintStream(System.out);
	
	public ThreadEscuchaServidor() {
		
	}
	public void run(DataInputStream disSer, DataOutputStream dosSer) {
		
		boolean funciona = true;
		
		while (funciona == true) {
			String msg = null;
			try {
				msg = disSer.readUTF();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(msg != null) {
				ps.println("--" + msg);
				try {
					dosSer.writeUTF("\u001B[31m"+msg);
					dosSer.flush();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else if(msg.equals("/salir")) {
				funciona = false;
				ps.println("Conexion Terminated");
				try {
					dosSer.writeUTF("Conecction Terminated");
					dosSer.flush();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
	}
}
