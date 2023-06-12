package main_package;
import Class.System.*;
import Readers.*;
public class main {
	static EntradaDeDatos ed = new EntradaDeDatos();
	static ReaderClass rc = new ReaderClass();
	public static void main(String[] args) {
		String pedirDato = ed.Leer();
		int numero = Integer.parseInt(ed.Leer());
		float otronum = Float.parseFloat(ed.Leer());
		
		String pedirDatoBasado = rc.Leer();
	}

}
