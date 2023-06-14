package Utilidades;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LeerArchivos {
	public LeerArchivos() {
		
	}
	public static String LeerArchivoBuffered(File a) {
		String texto = "";
		try {
			FileReader fr = new FileReader(a);
			BufferedReader br = new BufferedReader(fr);

			String linea = "";

			while((linea = br.readLine()) != null) {
				texto += "\n" + linea;
			}
			br.close();
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		return texto;
	}
}
