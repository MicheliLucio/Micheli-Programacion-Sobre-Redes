package Readers;
import java.util.ArrayList;
import java.util.List;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.LinkedList; 
import java.util.Map;
import java.util.TreeMap;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.LinkedHashMap;
import java.util.HashSet;
import java.util.Set;


public class Colleciones {
	public Colleciones() {
		PrintStream ps = new PrintStream(System.out);
		
		ArrayList<String> frutas = new ArrayList<String>();
		List<String> verduras = new ArrayList<String>();
		
		//Agregar o eliminar datos de un array - LinkedList
		LinkedList<String> animales = new LinkedList<String>();
		
		// Diccionarios
		Map<String, String> InglesEspanol = new HashMap<String, String>();
		InglesEspanol.put("Hello", "Hola");
		InglesEspanol.put("Hi", "Hola");
		InglesEspanol.put("HELLO", "Hola");
		
	    frutas.add("Frutilla");
	    frutas.add("Manzana");
	    frutas.add("Banana");
	    
	    //For tradicional
	    ps.println("For Tradicional");
	    for(int i = 0; i < frutas.size(); i++) {
	    	ps.println(frutas.get(i));
	    }
	    
	    //For each
	    ps.println("For Each");
	    for(String fruta : frutas) {
	    	ps.println(fruta);
	    }
	    
	    ps.println("Iterator");
	    Iterator i = frutas.iterator();
	    while(i.hasNext()) {
	    	String aux = (String)i.next();
	    	ps.println(aux);
	    	
	    }
	    
	    // HASHMAP -> MAP -> ITERATOR
	    Iterator element = InglesEspanol.keySet().iterator();
	    while(element.hasNext()) {
	    	String key = (String)element.next();
	    	String value = InglesEspanol.get(key);
	    }
	    
	    //Métodos del HashMap
	    InglesEspanol.containsKey("Hello"); //Una sola aparicion
	    InglesEspanol.containsValue("Hola"); //Varias apariciones
	    InglesEspanol.replace("hi","holi"); // Solo se cambia el value
	    
	    //Treemap
	    TreeMap<Integer, String> DNI = new TreeMap<Integer, String>();
	    DNI.put(100000, "pepe");
	    DNI.put(800, "Hugo");
	    
	    
	    // HASHSET
	    HashSet<Integer> conjuntoNumeros = new HashSet<Integer>();
	    Set<Integer> conjunto2 = new HashSet<Integer>();
	    conjuntoNumeros.add(5);
	    
	    
	    // LINKEDHASHMAP
	    LinkedHashMap<Integer, Integer> alumnos = new LinkedHashMap<Integer, Integer>();
	    
	    
	    // Iteracion x entry
	    for( Map.Entry<String, String> item : InglesEspanol.entrySet() ) {
	    	item.getKey();
	    }
	    
	    
	    // conversion de Collection
	    Set<String> key = InglesEspanol.keySet();
	    ArrayList<String> valores = (ArrayList<String>)InglesEspanol.values();
	    
	    
	}
}
