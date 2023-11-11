package GuiaEjercicios;
import Readers.*;
import java.util.ArrayList;
import java.io.IOException;
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
	public void Ejercicio2B() {
		ArrayList<Integer> numeros = new ArrayList();
		for(int i = 0; i < 4; i++) {			
			ps.println("Ingrese un numero real por favor: ");
			int numero = Integer.parseInt(rc.Leer());
			numeros.add(numero);
		}
		Collections.sort(numeros);
		
		
		ps.println("Los numeros son: "+ numeros + " Y el numero menor de la lista es: "+numeros.get(0));
	}
	public void Ejercicio2C() {
		ps.println("Ingrese un numero para verificar si es par o impar: ");
		int numero = Integer.parseInt(rc.Leer());
		int resto = numero % 2;
		if(resto == 0) {
			ps.println("El numero es par.");
		}else {
			ps.println("El numero es impar");
		}
		
	}
	public void Ejercicio2D() {
		ArrayList<Integer>numeros = new ArrayList();
		ps.println("Ingrese un numero: ");
		int numero1 = Integer.parseInt(rc.Leer());
		numeros.add(numero1);
		ps.println("Ingrese OTRO numero: ");
		int numero2 = Integer.parseInt(rc.Leer());
		while(numero1 == numero2) {
			ps.println("Dije O͟T͟R͟O͟ numero!: ");
			numero2 = Integer.parseInt(rc.Leer());
		}
		numeros.add(numero2);
		Collections.sort(numeros);
		int numeromen = numeros.get(0);
		int numeromay = numeros.get(1);
		int resto = numeromay % numeromen;
		if(resto == 0) {
			ps.println("El numero mayor: "+numeromay+" es divisible por el numero menor: "+numeromen);
		}else {
			ps.println("El numero mayor: "+numeromay+" NO es divisible por el numero menor: "+numeromen);
		}
		
	}
	public void Ejercicio2E() {
		ps.println("En proceso");
	}
	public void Ejercicio2F() {
		ps.println("Ingrese UN nombre y apellido: ");
		String nombre1 = rc.Leer();
		ps.println("Ingrese UN nombre y apellido mas: ");
		String nombre2 = rc.Leer();
		
		int cantidad1 = nombre1.length() - 1;
		int cantidad2 = nombre2.length() - 1;
		
		if(cantidad1 > cantidad2) {
			ps.println(nombre1+" ("+cantidad1+" Letras"+")" +" Es mas largo que "+nombre2+" ("+cantidad2+" Letras"+")");
		}else if(cantidad1 == cantidad2){
			ps.println(nombre1+" ("+cantidad1+" Letras"+")" +" Es igual de largo que "+nombre2+" ("+cantidad2+" Letras"+")");
		}else {
			ps.println(nombre2+" ("+cantidad2+" Letras"+")" +" Es mas de largo que "+nombre1+" ("+cantidad1+" Letras"+")");
		}
	}
	public void Ejercicio2G() {
		ArrayList<Integer> tablaMultiplicar = new ArrayList();
		ps.println("Ingrese un numero NATURAL para ver su tabla de multiplicar: ");
		int numero = Integer.parseInt(rc.Leer());
		while(numero <=0) {
			ps.println(numero+" NO es NATURAL. Ingrese otro numero: ");
			numero = Integer.parseInt(rc.Leer());
		}
		for(int i = 1; i<10+1; i++) {
			int resultado = numero * i;
			tablaMultiplicar.add(resultado);
		}
		ps.println("La tabla del "+numero+ " es: "+tablaMultiplicar);
		
	}
	public void Ejercicio2H() {
		ps.println("Ingrese un numero NATURAL para verificar si es primo o no: ");
		int numero = Integer.parseInt(rc.Leer());
		while(numero <=0) {
			ps.println(numero+" NO es NATURAL. Ingrese otro numero: ");
			numero = Integer.parseInt(rc.Leer());
		}
		int resto = numero % 2;
		if(resto == 0 && numero != 2) {
			ps.println("El numero "+numero+" NO es primo");
		}else {
			ps.println("El numero "+numero+" SI es primo");
		}
	}
	
}
