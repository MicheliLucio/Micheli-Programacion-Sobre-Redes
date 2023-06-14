package PlaneFile;

import java.io.File; 
import java.io.Serializable;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream; 
import java.io.IOException; 
import java.io.FileInputStream;
import java.io.ObjectInputStream; 
import java.io.PrintStream;
import java.io.BufferedReader; 
import java.io.InputStreamReader; 

public class BinaryFile implements Serializable {
	public static final long serialVersionUID = -123456L;
	
	public void Serializar(String ruta) throws IOException{
		File archivo = new File(ruta);
		//canal de comunicaciones
		FileOutputStream fos = new FileOutputStream(archivo);
		
		//Ahora podemos escribir el archivo binario con este objeto
		ObjectOutputStream escribir = new ObjectOutputStream(fos);
		escribir.writeObject(this);
		escribir.close();
	}
	
	public BinaryFile deSerializar(String ruta) throws IOException, ClassNotFoundException {
		File archivo = new File(ruta);
		FileInputStream fis = new FileInputStream(archivo);
		
		ObjectInputStream lector = new ObjectInputStream(fis);
		return (BinaryFile)lector.readObject();
	}
	
	
	/*Aca empieza el main del programa*/
	String numero;
	public void ejecutarPrograma() throws IOException{
		PrintStream ps = new PrintStream(System.out);
		ps.println("La variable guardo: " + numero);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		ps.println("\tIngrese un valor para guardar");
		numero = br.readLine();
	}
}
