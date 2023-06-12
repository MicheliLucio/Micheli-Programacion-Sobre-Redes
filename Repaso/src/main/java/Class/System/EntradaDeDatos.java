package Class.System;

import java.io.FileOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EntradaDeDatos {
	public EntradaDeDatos() {
		PrintStream ps = new PrintStream(System.out);
		
		try {
			ps.print("Entrada: ");
			int Byte = 0;
			String cadena = "";
			while((Byte = System.in.read()) != '\n' ) {
				cadena += (char)Byte;
			}
			ps.println(cadena);
			//ps.println( (char)System.in.read());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
