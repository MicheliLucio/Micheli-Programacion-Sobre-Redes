package main_package;
import Class.System.*;
public class main {
	static EntradaDeDatos ed = new EntradaDeDatos();
	public static void main(String[] args) {
		String pedirDato = ed.Leer();
		int numero = Integer.parseInt(ed.Leer());
		float otronum = Float.parseFloat(ed.Leer());
	}

}
