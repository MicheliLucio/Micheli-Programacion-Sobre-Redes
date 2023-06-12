package PlaneFile;

import java.io.File; 
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileNotFoundException; 
import java.io.PrintStream;
import java.io.PrintWriter;  
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.BufferedReader;

public class file {
	
	File error;
	FileWriter fw;
	
	public file() {
		error = new File("errores.log");
		try {
			fw = new FileWriter(error, true);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		//this.CrearConPrintStream();
		//this.CrearConPrinter();
		this.CrearConBuffered();
	}
	
	public void CrearConPrintStream() {
		try {
			FileOutputStream fos = new FileOutputStream(error);
			//fos.write(null); <-- System
			PrintStream ps = new PrintStream(fos, true); // true append apagado, false append prendido
			
			ps.println("Primera linea de datos escrita en un archivo.");
			ps.flush();
			ps.close();
			fos.close();
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void CrearConPrinter() {
		PrintWriter pw = new PrintWriter(fw);
		pw.println("Esto es otra linea.");
	}
	
	public void CrearConBuffered() {
		BufferedWriter bw = new BufferedWriter(fw);
		try {
			bw.write("Yippieee, buffered.");
			bw.newLine();
			
			bw.flush();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(bw != null) 
					bw.close();
				
				if(fw != null)
					fw.close();
			}
			catch(IOException e){
				e.printStackTrace();
			}
		}
	}
	
	public void LeerArchivoBuffered() {
		String texto = "";
		try {
			FileReader fr = new FileReader(error);
			BufferedReader br = new BufferedReader(fr);
			
			String linea = "";
			
			while((linea = br.readLine()) != null) {
				texto += "\n" + linea;
			}
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		
	}
}
