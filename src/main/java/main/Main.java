package main;
import java.io.PrintStream;
import utiles.ReaderClass;
import ejercicios.*;

public class Main {
	static PrintStream ps = new PrintStream(System.out);
	static ReaderClass reader = new ReaderClass();
	static Ejercicio1 ej1 = new Ejercicio1(); 
	static Ejercicio2 ej2 = new Ejercicio2();
	static Ejercicio3 ej3 = new Ejercicio3();
	
	public static void main(String[] args) {
		Menu();
	}
	
	public static void Menu() {
		ps.println("Seleccione un ejercicio: ");
		ps.println("1 - Ejercicio 1");
		ps.println("2 - Ejercicio 2");
		ps.println("3 - Ejercicio 3");
		ps.println("0 - Salir.");
		switch(Integer.parseInt(reader.Leer())) {
			case 1:
				ps.println("Ejercicio 1: ");
				ej1.Ejercicio1();
				Menu();
				break;
			case 2:
				ps.println("Ejercicio 2: ");
				ej2.Ejercicio2();
				Menu();
				break;
			case 3:
				ps.println("Ejercicio 3: ");
				ej3.Ejercicio3();
				Menu();
				break;
			case 0:
				ps.println("Saliste del programa");
				break;
			default:
				ps.println("Numero incorrecto intente nuevamente.");
				Menu();
				break;
		}
	}

}
