package GuiaEjercicios;
import Readers.*;
import java.util.ArrayList;
import java.io.PrintStream;
import java.util.Collections;

public class Ejercicio2 {
	static PrintStream ps = new PrintStream(System.out);
	static ReaderClass rc = new ReaderClass();
	public Ejercicio2() {
		
	}
	public void Ejercicio2A() {
		ArrayList<String> apellidos = new ArrayList();
		for(int i = 0; i < 3; i++) {
			ps.println("Ingrese UN apellido: ");
			String apellido = rc.Leer();
			apellidos.add(apellido);
			
		}
		Collections.sort(apellidos);
		ps.println("Los apellidos son: "+apellidos);
		
	}
}
