package hilos;

import java.io.PrintStream;

public class CicloVida extends Thread{
	
	static PrintStream ps;
	public CicloVida() {
		ps = new PrintStream(System.out);
		this.setName("multiplicaX1000");
		
	}
	
	@Override
	public void run() {
		//aca dentro estan las acciones del HILO
		
		long a = 1;
		for(int i = 0; i<1000000 ; i++) {
			a = a * 5000;
			ps.println(a);
		}
		ps.println(a);
	}
}
