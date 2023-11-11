package principal;

import PlaneFile.*;

import java.io.PrintStream;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.IOException; 
import java.io.FileNotFoundException; 

public class main {

	public static void main(String[] args) {
		file archivo = new file();
		PrintStream pso = new PrintStream(System.out);
		
		/*Otra forma*/
		try {
			System.setErr(new PrintStream(new File("crasheo.log")));
		}catch(FileNotFoundException e) {
			
		}
		
		BinaryFile archBin = new BinaryFile(); //programa
		String bin = "Dumpmemory.bin"; //arcivo 
		
		try {
			//Se abre un archivo de memoria
			archBin = archBin.deSerializar(bin);
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		finally {
			try {
				archBin.ejecutarPrograma();
			}catch(IOException uwu) {
				uwu.printStackTrace();
			}
			
		}
		
		//aca en teoria se ejecuta el programa
		try{
			archBin.Serializar(bin);
			pso.println("\tGracias x usar el programa");
		}catch(IOException ex) {
			PrintStream ps = new PrintStream(System.err);
			ps.println(ex.getMessage());
		}
	}
}
