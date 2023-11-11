package Class.System;

public class cadenas {
	public cadenas() {
		String cadena = "Hola Twitter";
		String cadena2 = "chau";
		
		cadena.length(); //largo
		cadena.concat(cadena2); //Concatena cadenas
		cadena.split(","); //Separador, devuelve vec[]
		cadena.toLowerCase(); //todo minúsculas
		cadena.toUpperCase(); //todo mayúsculas
		cadena.substring(2);
		cadena.substring(2, 5);
		cadena.charAt(5); //devuleve el caracter especificado.
		cadena.trim(); //limpia espacios.
		cadena.indexOf("la"); //devuelve la posicion donde se encuentra la palabra o -1
		cadena.lastIndexOf("a"); //ultima posicion donde se encuentra o -1
		cadena.replace("a", "b");
		cadena.replaceAll("todo", "cadena");
		cadena.toCharArray();
		cadena.compareTo(cadena2);
		cadena.compareToIgnoreCase(cadena2);
		cadena.equals(cadena2); //lo mismo que usar ==
		cadena.contains("ho");
		cadena.startsWith("Even");
		cadena.endsWith("Flow");
		
		cadena.codePointAt(4); //devuelve el codigo ascii o unicode
		cadena.isEmpty();
		
		char[] a = {5, 4, 7, 9, 3};
		cadena.copyValueOf(a); //mete la cadena
		
		cadena.split(","); //Separador vec[]
		
	}
}
