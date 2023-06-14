/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainPackage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Logger;
import Archivos.ArchivosDatos;
import java.io.PrintStream;


/**
 *
 * @author 
 */
public class Main {
	static PrintStream ps = new PrintStream(System.out);
    private static final Logger LOG = Logger.getLogger(Main.class.getName());
    static File archivo = new File("juegos.dat");
    
    
    
    /**
     * SOLO PREPARAR EL ARCHIVO (CON ORIENCION A OBJETOS) Y LUEGO LLAMAR AL FUNCIONAMIENTO DEL PROGRAMA
     * @param args 
     */
    public static void main(String[] args) {
    	ArchivosDatos.arreglar(archivo);
    	ArchivosDatos.mostrar(archivo);
        
        
        
    }
    
    
    
}
