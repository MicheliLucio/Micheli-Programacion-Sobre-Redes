package modulo5;
import java.io.PrintStream;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;

import leer.ReaderClass;

import java.io.FileWriter;
import planefile.Archivo;

public class EjerciciosExtra {
	static Archivo arc = new Archivo();
	static PrintStream ps = new PrintStream(System.out);
	static ReaderClass rc = new ReaderClass();
	File archivo;
	FileWriter fw;
	Map<String, String> climas = new LinkedHashMap<String, String>();
	
	public EjerciciosExtra() {
		
	}
	
	public void EE1() {
		archivo = new File("index.html");
		String html = arc.LeerArchivoBuffered(archivo);
		int inicioLorem = html.indexOf("<p>");
		int finalLorem = (html.indexOf("</p>") + 4);
		String borrar = html.substring(inicioLorem, finalLorem);
        html = html.replace(borrar, "");
        try {
			fw = new FileWriter(archivo);
		}catch (IOException e) {
			e.printStackTrace();
		}
		PrintWriter pw = new PrintWriter(fw);
		pw.print(html);
		try {
			fw.flush();
			pw.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		ps.println("Archivo sin lorem: ");
		ps.println(arc.LeerArchivoBuffered(archivo));
	}
	
	public void EE2() {
		ps.println("Bienvenido a Registros del Clima. ¿Qué desea hacer?");
		ps.println("1- Insertar.");
		ps.println("2- Mostrar las fechas y climas.");
		ps.println("3- Eliminar una entrada.");
		ps.println("0- Terminar.");
		switch(Integer.parseInt(rc.Leer())) {
		case 1:
			ps.println("Ingrese una fecha (DD/MM/YYYY): ");
			String fecha = rc.Leer();
			ps.println("Ingrese datos del clima: ");
			String clima = rc.Leer();
			addAlumno(fecha, clima);
			EE2();
			break;
		case 2:
			ps.println("A continuación todos los datos: ");
			showAll();
			EE2();
			break;
		case 3:
			ps.println("Ingrese la fecha que desea borrar.");
			String fechaBorrar = rc.Leer();
			ps.println("Ingrese los datos de clima que desea borrar: ");
			String climaBorrar = rc.Leer();
			borra(fechaBorrar, climaBorrar);
			EE2();
			break;
		case 0:
			ps.println("Seleccionaste 0. Adiós!");
			break;
		default:
			ps.println("Opción inválida, intente de nuevo.");
			EE2();
			break;
		}
	}
	
	public void addAlumno(String f, String c) {
		climas.put(f, c);
		ps.println("Entrada ingresada con éxito.");
	}
	
	public void showAll() {
		for(Map.Entry<String, String> item : climas.entrySet()) {
			ps.println("Fecha: " + item.getKey() + " Clima: " + item.getValue());
		}
	}
	
	public void borra(String f, String c) {
		climas.remove(f, c);
	}
}
