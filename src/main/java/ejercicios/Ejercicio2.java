package ejercicios;
import java.io.PrintStream;
import utiles.ReaderClass;
import utiles.Archivos;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Ejercicio2 {
	static PrintStream ps = new PrintStream(System.out);
	static ReaderClass rc = new ReaderClass();
	static Archivos arc = new Archivos();
	static Ejercicio1 ejercicio1 = new Ejercicio1();
	File results;
	File errors;
	FileWriter fw;
	PrintWriter pw;
	
	public Ejercicio2() {
		
	}
	
	public void Ejercicio2() {
		ps.println("Se le redirecciona al ejercicio 1");
		int[] numeros = ejercicio1.Ejercicio1();
		String Resultados = "";
		String Errores = "";
		for(int i = 0; i < numeros.length; i++) {
			try {
				int Divisor = numeros[(i+1)] - 3;
				int resultado = numeros[i] / Divisor;
				Resultados += String.valueOf(numeros[i]) + " / " + String.valueOf(Divisor) + " = " + String.valueOf(resultado) + "\n";
			}catch(NullPointerException e) {
				Errores += String.valueOf(numeros[i]) + " / (siguiente número) = ERROR (Fin del Array) \n";
			}catch (ArithmeticException e) {
				Errores += String.valueOf(numeros[i]) + " / " + String.valueOf(0) + " = ERROR (División por 0) \n";
			}
		}
		results = new File("resultados.txt");
		errors = new File("error.txt");
		try {
			fw = new FileWriter(results);
		} catch (IOException e) {
			e.printStackTrace();
		}
		pw = new PrintWriter(fw);
		
		pw.print(Resultados);
		
		try {
			fw.flush();
			pw.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			fw = new FileWriter(errors);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		PrintWriter pw2 = new PrintWriter(fw);
		pw2.print(Errores);
		
		try {
			fw.flush();
			pw2.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		ps.println("resultados.txt: ");
		ps.println(arc.LeerArchivoBuffered(results));
		ps.println("error.txt: ");
		ps.println(arc.LeerArchivoBuffered(errors));
	}
}
