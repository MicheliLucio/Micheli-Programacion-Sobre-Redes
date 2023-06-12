package GuiaEjercicios;
import Class.System.*;
import java.io.PrintStream;

public class Ejercicio1 {
	static PrintStream ps = new PrintStream(System.out);
	static EntradaDeDatos ed = new EntradaDeDatos();
	
	public Ejercicio1(){
		
	}
	
	public void EjercicioA(){
		ps.println("Ingrese el valor por hora: ");
		double valorporhora = Double.parseDouble(ed.Leer());
		ps.println("Ingrese la cantidad de horas trabajada: ");
		double cantidaddehorastrabajada = Double.parseDouble(ed.Leer());
		double sueldoBruto = 0;
		
		sueldoBruto = valorporhora * cantidaddehorastrabajada;
		
		ps.println("El sueldo bruto es: "+sueldoBruto+"$");
	}
	public void EjercicioB() {
		ps.println("Dar el primer angulo interior: ");
		double angulo1 = Double.parseDouble(ed.Leer());
		ps.println("Dar el segundo angulo interior: ");
		double angulo2 = Double.parseDouble(ed.Leer());
		
		double suma = angulo1 + angulo2;
		double angulo3 = 180 - suma;
		
		ps.println("El tercer angulo es: "+angulo3);
	}
		

}
