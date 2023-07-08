package ejercicios;
import java.io.PrintStream;
import utiles.SystemRead;
import utiles.ReaderClass;
import utiles.Archivos;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Ejercicio1 {
	static PrintStream ps = new PrintStream(System.out);
	static SystemRead sr = new SystemRead();
	static ReaderClass rc = new ReaderClass();
	static Archivos arc = new Archivos();
	File numbers;
	FileWriter fw;
	int[] numeros = new int[5];
	public Ejercicio1() {
		
	}
	
	public int[] Ejercicio1() {
		
		ps.println("Ingrese 10 números.");
		ps.println("Debe ingresar 0 en cada uno de los tipos de almacenamiento.");
		for(int i = 0; i < 5; i++) {
			ps.println("Ingrese el número " + (i+1) + ": ");
			numeros[i] = Integer.parseInt(sr.Leer());
		}
		
		numbers = new File("numeros.txt");
		try {
			fw = new FileWriter(numbers);
		} catch (IOException e) {
			e.printStackTrace();
		}
		PrintWriter pw = new PrintWriter(fw);
		
		for(int i = 6; i < 11; i++) {
			ps.println("Ingrese el número " + i + ": ");
			pw.println(Integer.parseInt(rc.Leer()));
		}
		try {
			fw.flush();
			pw.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		ps.println("Números array: ");
		for(int n : numeros) {
			ps.println(n);
		}
		
		ps.println("Números archivo: ");
		ps.println(arc.LeerArchivoBuffered(numbers));
		
		return numeros;
	}
}
