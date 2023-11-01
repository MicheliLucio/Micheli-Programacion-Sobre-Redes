package hilos;

import java.io.PrintStream;

public class main {
	
	static PrintStream ps;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CicloVida hilo = new CicloVida();
		ps = new PrintStream(System.out);
		
		
		Thread hilo_2 = new Thread(
				// Runnable es crear una tarea
				new Runnable() {
					@SuppressWarnings("static-access")
					public void run() {
						for(int i = 0 ; i<10;i++) {
							ps.println(Thread.currentThread().getName() + ":" + i);
							try {
								Thread.currentThread().sleep(200);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
				}, "Del 1 al 10"
			);
		
		hilo_2.start();

		//hilo.run no llama al hilo si no al metodo
		ps.println(Thread.currentThread().getName());
		
		hilo.start();
		try {
			Thread.currentThread().sleep(200);
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(hilo.getState() == Thread.State.TIMED_WAITING) {
			
		}
		
		while(hilo.getState() != Thread.State.TERMINATED){
			ps.println(hilo.getState());
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
