package modulo4;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Iterator;
import java.io.PrintStream;
import java.util.ArrayList;

public class Colegio {
	static PrintStream ps = new PrintStream(System.out);
	Map<String, String> alumnos = new LinkedHashMap<String, String>();
	
	public Colegio() {
		
	}
	
	public void addAlumno(String apellido, String nacionalidad) {
		alumnos.put(apellido, nacionalidad);
		ps.println("Alumno registrado.");
	}
	
	public void showAll() {
		for(Map.Entry<String, String> item : alumnos.entrySet()) {
			ps.println("Nacionalidad: " + item.getValue() + " Apellido: " + item.getKey());
		}
	}
	
	public void showNacionalidad(String nacionalidad) {
		if(alumnos.containsValue(nacionalidad)) {
			Iterator e = alumnos.keySet().iterator();
			int contador = 0;
	        while( e.hasNext() )
	        {
	        	String key   = (String)e.next();    	
	        	String value = alumnos.get( key );
	        	if(value.equalsIgnoreCase(nacionalidad)) {
	        		contador++;
	        	}
	        }
	        ps.print("Nacionalidad: " + nacionalidad);
	        ps.println("Cantidad de alumnos: " + contador);
		}else {
			ps.println("La nacionalidad no esta registrada.");
		}
	}
	
	public void cuantos() {
		Iterator e = alumnos.keySet().iterator();
		String valorAnterior = "";
		ArrayList<String> nacs = new ArrayList<String>();
        while( e.hasNext() )
        {
        	String key   = (String)e.next();    	
        	String value = alumnos.get( key );
        	if(!(value.equalsIgnoreCase(valorAnterior))) {
        		nacs.add(value);
        		valorAnterior = value;
        	}
        }
        
        ps.println("Nacionalidades diferentes: " + nacs.size());
        for(String n : nacs) {
        	ps.println(n);
        }
	}
	
	public void borra() {
		alumnos.clear();
		ps.println("Se eliminaron correctamente todos los datos.");
	}
}
