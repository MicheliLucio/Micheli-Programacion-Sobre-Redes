/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Archivos;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintStream;
import java.util.logging.Logger;
import Readers.ReaderClass;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.BufferedReader;
import Utilidades.LeerArchivos;



/**
 * ACA TODO LO QUE TENGA QUE VER CON LEER DATOS DE UN ARCHIVO, ESCRIBIR, BORRAR
 * FUNCIONALIDAD DE ARREGLADO DE FORMATO, Y OJO!! ACA DEBE ESTAR LA
 * DUNCIONALIDAD DE MOSTRAR LOS DATOS DEL ARCHIVO
 *
 * @author
 */
public class ArchivosDatos {
	
	  static PrintStream ps = new PrintStream(System.out);
	  static ReaderClass rc = new ReaderClass();
	  static LeerArchivos la = new LeerArchivos();
	  static File archivo;
	  static FileWriter fw;
		


    private static final Logger LOG = Logger.getLogger(ArchivosDatos.class.getName());


    public ArchivosDatos() {
    }
 

    /**
     *
     */
    public static void mostrar(File archivo) {
    		ps.println(la.LeerArchivoBuffered(archivo));
    }
    
    

    /**
     *
     */
    public static void arreglar(File archivo) {
    	String texto = "";
    	try {
    		FileReader fr = new FileReader(archivo);
    		BufferedReader br = new BufferedReader(fr);
    		String linea = "";
    		while((linea = br.readLine()) != null) {
    			if(linea.contains(String.valueOf('1'))) {
					texto += ";";
				}else {
					texto += linea + "\n";
				}
    		}
    		br.close();
    		fr.close();
    		
    	}catch(FileNotFoundException e) {
    		e.printStackTrace();
    	}catch(IOException e) {
    		e.printStackTrace();
    	}
    	try {
			fw = new FileWriter(archivo);
		}catch (IOException e) {
			e.printStackTrace();
		}
		PrintWriter pw = new PrintWriter(fw);
		pw.print(texto);
		try {
			fw.flush();
			pw.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
    	

    	
    }

 

    /**
     *
     */
    public void eliminar() {

    }

    /**
     *
     */
    public void escribir() {

    }
    

}
