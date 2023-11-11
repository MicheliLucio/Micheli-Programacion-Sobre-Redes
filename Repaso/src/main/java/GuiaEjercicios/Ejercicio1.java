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
	
	public void EjercicoC() {
		ps.println("Dar el primer lado del cuadrado en (m2): ");
		double lado = Double.parseDouble(ed.Leer());
		double perimetro = lado * 4;
		
		ps.println("El perimetro del cuadrado es "+perimetro+" (m2)");
	}
		
	
	public void EjercicioD() {
		ps.println("Ingrese la temperatura en grados farenheit: ");
		double farenheit = Double.parseDouble(ed.Leer());
		double restaTemperatura = farenheit - 32;
		double multiplicacionTemperatura = restaTemperatura * 5;
		double celsius = multiplicacionTemperatura / 9;
		
		ps.println(farenheit + " grados farenheit son equivalentes a "+celsius+" grados celsius");
	}
	
	public void EjercicioE() {
		ps.println("Dar un tiempo en segundos: ");
		int segundos = Integer.parseInt(ed.Leer());
		int minuto = segundos / 60;
		segundos = segundos % 60;
		int hora = minuto / 60;
		minuto = minuto % 60;
		int dias = hora / 24;
		hora = hora % 24;
		
		
		
		
		ps.println("Los segundos en dias: "+dias+", horas: "+hora+", minutos: "+minuto+", segundos: "+segundos);
		
	}
	public void EjercicioF() {
		ps.println("Ingrese el precio del articulo: ");
		double precio = Double.parseDouble(ed.Leer());
		double porcentaje1 = precio * 10 / 100;
		double plan1 = precio - porcentaje1;
		ps.println("El precio del articulo implementando el plan 1 es: "+plan1+"$");
		double porcentaje2 = precio * 50 / 100;
		double resto2 = precio * 50 % 100;
		double incremento2 = precio *10 /100;
		double cuotas2 = resto2 / 2;
		double plan2 = precio - porcentaje2 + incremento2;
		ps.println("El precio del articulo implementando el plan 2 es: "+ plan2 +"$"+" se le suma 2 cuotas de "+cuotas2+"$");
		double porcentaje3 = precio * 25 / 100;
		double resto3 = precio * 25 % 100;
		double incremento3 = precio * 15 / 100;
		double cuotas3 = resto3 / 5;
		double plan3 = precio - porcentaje3 + incremento3;
		ps.println("El precio del articulo implementando el plan 3 es: "+plan3 +"$"+" se le suma 5 cuotas de "+cuotas3+"$");
		double porcentaje4 = precio * 60 / 100;
		double cuotas4iniciales = porcentaje4 / 4;
		double incremento4 = precio * 25 / 100;
		double cuotas4finales = cuotas4iniciales + incremento4;
		ps.println("El precio del articulo se divide en 8 cuotas donde las primeras 4 son de: "+cuotas4iniciales+"$"+" las otras 4 cuotas "+cuotas4finales+"$");
	}
	public void EjercicioG() {
		ps.println("Ingrese su signo zodiacal: ");
			if(ed.Leer().equalsIgnoreCase("Aries")) {
				ps.println("Usted nació a fines de marzo o en abril.");
			}else if(ed.Leer().equalsIgnoreCase("Tauro")) {
				ps.println("Usted nació a fines de abril o en mayo.");
			}else if(ed.Leer().equalsIgnoreCase("Géminis")) {
				ps.println("Usted nació a fines de mayo o en junio.");
			}else if(ed.Leer().equalsIgnoreCase("Cáncer")) {
				ps.println("Usted nació a fines de junio o en julio.");
			}else if(ed.Leer().equalsIgnoreCase("Leo")) {
				ps.println("Usted nació a fines de julio o en agosto.");
			}else if(ed.Leer().equalsIgnoreCase("Virgo")) {
				ps.println("Usted nació a fines de agosto o en septiembre.");
			}else if(ed.Leer().equalsIgnoreCase("Libra")) {
				ps.println("Usted nació a fines de spetiembre o en octubre.");
			}else if(ed.Leer().equalsIgnoreCase("Escorpio")) {
				ps.println("Usted nació a fines de octubre o en noviembre.");
			}else if(ed.Leer().equalsIgnoreCase("Sagitario")) {
				ps.println("Usted nació a fines de noviembre o en diciembre.");
			}else if(ed.Leer().equalsIgnoreCase("Capricornio")) {
				ps.println("Usted nació a fines de diciembre o en enero.");
			}else if(ed.Leer().equalsIgnoreCase("Acuario")) {
				ps.println("Usted nació a fines de enero o en febrero.");
			}else if(ed.Leer().equalsIgnoreCase("Piscis")) {
				ps.println("Usted nació a fines de febrero o en marzo.");
			}else {
				ps.println("Usted no ha ingresado un signo Zodiacal válido. Inténtelo nuevamente. Pruebe utilizando mayúscula en la primer letra.");
		
			}

		}

}
