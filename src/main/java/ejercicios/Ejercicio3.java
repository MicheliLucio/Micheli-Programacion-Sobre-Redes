package ejercicios;
import java.io.PrintStream;
import utiles.ReaderClass;
import utiles.Archivos;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class Ejercicio3 {
	static PrintStream ps = new PrintStream(System.out);
	static ReaderClass rc = new ReaderClass();
	static Archivos arc = new Archivos();
	static Ejercicio1 ejercicio1 = new Ejercicio1();
	File numbers = new File("numeracos.txt");
	File results;
	File errors;
	FileWriter fw;
	PrintWriter pw;
	public Ejercicio3() {
		
	}
	
	public void Ejercicio3() {
		ps.println("Se le redireccionará al ejercicio 1");
		int[] numeros = ejercicio1.Ejercicio1();
		String Resultados = "";
		String Errores = "";
		ArrayList<Integer> allNums = new ArrayList<Integer>();
		for(int i = 0; i < numeros.length; i++) {
			allNums.add(numeros[i]);
		}
		
		try {
			FileReader fr = new FileReader(numbers);
			BufferedReader br = new BufferedReader(fr);
			
			String linea = "";
			
			while((linea = br.readLine()) != null) {
				allNums.add(Integer.parseInt(linea));
			}
			br.close();
			fr.close();
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		for(int i = 0; i < allNums.size(); i++) {
			try {
				int resultado = allNums.get(i) / 3;
				Resultados += String.valueOf(allNums.get(i)) + " / " + String.valueOf(3) + " = " + String.valueOf(resultado) + "\n";
			}catch(NullPointerException e) {
				Errores += String.valueOf(allNums.get(i)) + " / (siguiente número) = ERROR (Fin del Array) \n";
			}catch (ArithmeticException e) {
				Errores += String.valueOf(allNums.get(i)) + " / " + String.valueOf(0) + " = ERROR (División por 0) \n";
			}catch (InputMismatchException ex) {
				Errores += String.valueOf(allNums.get(i)) + " / " + String.valueOf(0) + " = ERROR (Ingresó algo que no es un número) \n";
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
