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
		
	}
	public String Leer() {
		int Byte = 0;
		String cadena="";
		try {
			while ( ( Byte = System.in.read() ) != '\n' ){
					if ( Byte != '\r' )
						cadena += (char)Byte;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return cadena;
	}
}
