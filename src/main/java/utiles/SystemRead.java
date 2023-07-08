package utiles;

import java.io.IOException;

public class SystemRead {
	public SystemRead(){
		
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
