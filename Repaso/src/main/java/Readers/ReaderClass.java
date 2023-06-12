package Readers;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.Reader;
import java.io.BufferedReader;

public class ReaderClass {
	public ReaderClass() {
		
		PrintStream ps = new PrintStream(System.out);
		
		PrintStream err = new PrintStream(System.err);
		err.println();
		
		
		Reader lector = new InputStreamReader(System.in);
		InputStreamReader objeto = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(objeto);
		try {
			ps.println("Esto se lee con un buffer: ");
			ps.println(br.readLine());
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	public static String leer() {
		int Byte = 0;
		String cadena = "";
		try {
			while((Byte = System.in.read()) != '\n') {
				if(Byte != '\r');
				cadena += (char)Byte;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return cadena;
	}
}
