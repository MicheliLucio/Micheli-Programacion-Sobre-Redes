package Class.System;

import java.io.FileOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SalidaDeDatos {
	public SalidaDeDatos() {
		// TODO Auto-generated method stub
		
			//System.out.printf("Hola %s %c %d %f \n", "jsjs" , 64 , 5  , 6.1 );
			//System.err.println(" ERROR ");
				
			//System.out.append("fdfd \n");
			//System.out.flush();
			System.out.write(64);
			System.out.write(32); //Espacio
			System.out.write(64);
			System.out.write(13); //fin de linea
			System.out.write(10); //enter
			//System.out.print("");
				
			byte[] array = {72, 111, 108, 97, 32, 109, 117, 110, 100, 111};
				
			try {
				System.out.write( array);
				System.out.println();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			/*ERRORES*/
			Logger.getLogger(main.class.getName()).log(Level.SEVERE, "Error critico en el sistema.");
			
			/*ESCRIBIR EN CONSOLA*/
			PrintStream ps = new PrintStream( System.out ); //Optimiza el flujo de datos de salida
			ps.println("hola uwu");
				
			// c:\\user\documents\errores.log
			File archivo = new File("errores.log");
			FileOutputStream fos;
			try {
				fos = new FileOutputStream(archivo, true);
				PrintStream error = new PrintStream(fos);
				System.setErr(error);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
				
			System.err.println("Este error esta en un archivo");
			System.err.println("Otro error");
	}
}
