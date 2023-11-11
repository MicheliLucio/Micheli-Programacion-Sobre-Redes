package modulo4;
import java.io.PrintStream;
import java.util.List;
import java.util.Map;

import leer.ReaderClass;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Collections;

public class Ejercicio4 {
	static PrintStream ps = new PrintStream(System.out);
	static ReaderClass rc = new ReaderClass();
	Colegio col = new Colegio();
	public Ejercicio4() {
		
	}
	
	public void EjercicioA() {
		ps.println("Ingrese números. Para finalizar ingrese el número -99");
		List<Integer> numeros = leerValores();
		mostrarResultados(numeros);
	}
	
	public void EjercicioB() {
		ps.println("¿Qué desea hacer?");
		ps.println("1- Agregar un nuevo alumno.");
		ps.println("2- Mostrar todas las nacionalidades y sus alumnos.");
		ps.println("3- Mostrar una nacionalidad y cuantos alumnos.");
		ps.println("4- Mostrar cuantas nacionalidades.");
		ps.println("5- Eliminar todos los datos.");
		ps.println("0- Terminar.");
		switch(Integer.parseInt(rc.Leer())) {
		case 1:
			ps.println("Ingrese un apellido: ");
			String apellido = rc.Leer();
			ps.println("Ingrese una nacionalidad: ");
			String nac = rc.Leer();
			col.addAlumno(apellido, nac);
			EjercicioB();
			break;
		case 2:
			ps.println("A continuación todos los datos: ");
			col.showAll();
			EjercicioB();
			break;
		case 3:
			ps.println("Ingrese una nacionalidad: ");
			String nacio = rc.Leer();
			col.showNacionalidad(nacio);
			EjercicioB();
			break;
		case 4:
			ps.println("Cantidad de nacionalidades: ");
			col.cuantos();
			EjercicioB();
			break;
		case 5:
			ps.println("Se eliminaran todos los datos.");
			col.borra();
			EjercicioB();
			break;
		case 0:
			ps.println("Chauchas!");
			break;
		default:
			ps.println("Opción inválida, intente de nuevo.");
			EjercicioB();
			break;
		}
	}
	
	public void EjercicioC() {
		ps.println("Se crea la lista listDias: ");
		ArrayList<String> listDias = new ArrayList<String>();
		listDias.add("Lunes");
		listDias.add("Martes");
		listDias.add("Miércoles");
		listDias.add("Jueves");
		listDias.add("Viernes");
		listDias.add("Sábado");
		listDias.add("Domingo");
		ps.println("Agregamos en la posicion 4 el elemento 'Juernes'.");
		listDias.add(4, "Juernes");
		ps.println("Creamos una lista copia llamada listaDos.");
		ArrayList<String> listaDos = (ArrayList<String>) listDias.clone();
		ps.println("Agregamos todo el contenido de listaDos en listDias.");
		for(String d : listaDos) {
			listDias.add(d);
		}
		ps.println("A continuación muestro las posiciones 3 y 4 de la lista original.");
		ps.println(listDias.get(3));
		ps.println(listDias.get(4));
		ps.println("A continuación mostraré el primer y último elemento de la lista original.");
		ps.println(listDias.get(0));
		ps.println(listDias.get((listDias.size() - 1)));
		ps.println("A continuación se eliminará el/los elemento(s) 'Juernes'.");
		for(int i = 0; i < listDias.size(); i++) {
			if(listDias.get(i).equalsIgnoreCase("Juernes")) {
				listDias.remove(i);
			}
		}
		if(listDias.indexOf("Juernes") == -1) {
			ps.println("Se eliminó Juernes con éxito.");
		}else {
			ps.println("El valor no se eliminó.");
		}
		ps.println("A continuación se iterará la lista: ");
		Iterator e = listDias.iterator();
		while(e.hasNext()) {
			ps.println(e.next());
		}
		ps.println("Ahora buscaré si existe 'Lunes'");
		if(listDias.indexOf("Lunes") != -1) {
			ps.println("Lunes existe.");
		}else {
			ps.println("Lunes no existe.");
		}
		ps.println("Finalmente, se ordenará la lista.");
		Collections.sort(listDias);
		for(String d : listDias) {
			ps.println(d);
		}
	}
	
	public void EjercicioD() {
		ps.println("Se crea el conjunto jugadores: ");
		ArrayList<String> jugadores = new ArrayList<String>();
		jugadores.add("Jordi Alba");
		jugadores.add("Pique");
		jugadores.add("Busquets");
		jugadores.add("Iniesta");
		jugadores.add("Messi");
		
		ps.println("Se iterarán los jugadores: ");
		Iterator e = jugadores.iterator();
		while(e.hasNext()) {
			ps.println(e.next());
		}
		
		ps.println("Se revisa si existe Neymar Jr.");
		if(jugadores.indexOf("Neymar Jr.") != -1) {
			ps.println("Neymar Jr. está en la lista.");
		}else {
			ps.println("Neymar Jr. no está en la lista.");
		}
		
		ps.println("Se creará el conjunto jugadores2 con Piqué y Busquests");
		ArrayList<String> jugadores2 = new ArrayList<String>();
		jugadores2.add("Piqué");
		jugadores2.add("Busquets");
		
		ps.println("Se revisará si el conjunto 1 tiene todos los elementos del conjunto 2");
		boolean tieneTodo = jugadores.containsAll(jugadores2);
		if(tieneTodo == true) {
			ps.println("Jajja alto error si entra aca");
		}else {
			ps.println("Piqué es distinto de Pique.");
		}
		
		ps.println("Unión entre los conjuntos.");
		for(String j : jugadores2) {
			if(j != "Busquets") {
				jugadores.add(j);
			}
		}
		
		ps.println("Se intentará ingresar nuevamente a Piqué en jugadores");
		if(jugadores.indexOf("Piqué") != -1) {
			ps.println("Piqué ya está en la lista. No será ingresado.");
		}else {
			jugadores.add("Piqué");
			ps.println("Por algún motivo ingresé a Piqué.");
		}
		
		ps.println("Se iterarán los jugadores nuevamente: ");
		Iterator element2 = jugadores.iterator();
		while(element2.hasNext()) {
			ps.println(element2.next());
		}
	}
	
	public void EjercicioE() {
		Map<Integer, Map<String, Integer>> apuestas = new LinkedHashMap<Integer, Map<String, Integer>>();
		ps.println("¿Cuántas apuestas desea realizar?");
		int cantApuestas = Integer.parseInt(rc.Leer());
		for(int i = 0; i < cantApuestas; i++) {
			Map<String, Integer> bolas = new LinkedHashMap<String, Integer>();
			while(bolas.size() < 6) {
				int rojoActual = bolas.size() + 1;
				String bolaRojaActual = "Bola Roja - " + String.valueOf(rojoActual);
				int numerosRojos = (int)Math.floor(Math.random()*34+1);
				if(!bolas.containsValue(numerosRojos)) {
					bolas.put(bolaRojaActual, numerosRojos);
				}
			}
			int numApuesta = i + 1;
			String bolaAzulActual = "Bola Azul - " + String.valueOf(numApuesta);
			int numeroAzul = (int)Math.floor(Math.random()*17+1);
			bolas.put(bolaAzulActual, numeroAzul);
			
			apuestas.put(numApuesta, bolas);
		}
		
		ps.println("A continuación los resultados de las apuestas.");
		for(Map.Entry<Integer, Map<String, Integer>> item : apuestas.entrySet()) {
			ps.println("N° Apuesta: " + item.getKey() + " - Apuesta: " + item.getValue());
		}
	}
	
	public void EjercicioG() {
		ArrayList<String> provincias = new ArrayList<String>();
		ArrayList<String> nombres = new ArrayList<String>();
		Map<String, String> china = new LinkedHashMap<String, String>();
		provincias.add("Provincia de Heilongjiang");
		provincias.add("Provincia de Zhejiang");
		provincias.add("Provincia de Jiangxi");
		provincias.add("Provincia de Guangdong");
		provincias.add("Provincia de Fujian");
		nombres.add("Harbin");
		nombres.add("Hangzhou");
		nombres.add("Nanchang");
		nombres.add("Guangzhou");
		nombres.add("Fuzhou");
		
		for(int i = 0; i < provincias.size(); i++) {
			china.put(provincias.get(i), nombres.get(i));
		}
		
		ps.println("Se iterará el diccionario por Entry Set.");
		for(Map.Entry<String, String> item : china.entrySet()) {
			ps.println("Provincia: " + item.getKey() + " Nombre: " + item.getValue());
		}
		
		ps.println("Se iterará el diccionario por Key Set.");
		Iterator element = china.keySet().iterator();
        while( element.hasNext() )
        {
        	String key   = (String)element.next();    	
        	String value = china.get( key );
        	ps.println("Provincia: " + key + " Nombre: " + value);
        }
	}
	
	public List<Integer> leerValores() {
		List<Integer> numeros = new ArrayList<Integer>();
		while(Integer.parseInt(rc.Leer()) != (-99)) {
			numeros.add(Integer.parseInt(rc.Leer()));
		}
		return numeros;
	}
	
	public int calcularSuma(List<Integer> l) {
		Integer numTotal = 0;
		for(Integer num : l) {
			numTotal += num;
		}
		return numTotal;
	}
	
	public void mostrarResultados(List<Integer> l) {
		Integer promedio = calcularSuma(l) / l.size();
		Integer contador = 0;
		ps.println("Valores leídos: ");
		for(Integer n : l) {
			ps.println(n);
		}
		ps.println("Suma: " + calcularSuma(l));
		ps.println("Media: " + promedio);
		ps.println("Números que superan el promedio (" + promedio + "):");
		for(Integer num : l) {
			if(num > promedio) {
				contador++;
			}
		}
		ps.println("Los números que superan el promedio son: " + contador + " en total.");
	}
}
