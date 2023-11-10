package Threads;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;

public class ThreadEscuchaCliente extends Thread{
	PrintStream ps = new PrintStream(System.out);
	
	public ThreadEscuchaCliente() {
		
	}
	public void run(DataInputStream disCli) {
		
		
		while (true) {
			String msg = null;
			try {
				msg = disCli.readUTF();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(msg != null) {
				ps.println("--" + msg);
			}else if(msg.equals("/salir")) {
				break;
			}
			

		}
	}
}
