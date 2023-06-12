package modulo3;
import Readers.ReaderClass;
import java.io.PrintStream;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;

public class Ejercicio3 {
	static PrintStream ps = new PrintStream(System.out);
	static ReaderClass rc = new ReaderClass();
	File archivo;
	FileWriter fw;

	public Ejercicio3() {

	}

	public void EjercicioA() {
		archivo = new File("dato.txt");
		try {
			fw = new FileWriter(archivo);
		}catch (IOException e) {
			e.printStackTrace();
		}
		ps.println("Escriba un dato, por favor: ");
		String dato = rc.Leer();
		PrintWriter pw = new PrintWriter(fw);
		pw.println(dato);
		try {
				fw.flush();
				pw.close();
				fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
}

	public void EjercicioB() {
		archivo = new File("solonum.txt");
		try {
			fw = new FileWriter(archivo, true);
		}catch (IOException e) {
			e.printStackTrace();
		}
		ps.println("Escriba por favor: ");
		String dato = rc.Leer();
		PrintWriter pw = new PrintWriter(fw);
		if(dato != null && dato.matches("[0-9]+")) {
			pw.println(dato);
		}
		try {
			fw.flush();
			pw.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void EjercicioC() {
		archivo = new File("..\\numeros.txt");
		try {
			fw = new FileWriter(archivo, true);
		}catch (IOException e) {
			e.printStackTrace();
		}
		PrintWriter pw = new PrintWriter(fw);
		for(int i = 0; i < 1001; i++) {
			if(i % 2 == 0) {
				pw.println(i);
			}
		}
		try {
			fw.flush();
			pw.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		ps.println("Se finalizó el ejercicio.");
	}

	public void EjercicioD() {
		ps.println("Para hacer este ejercicio, usted debe hacer primero el C.");
		ps.println("¿Desea hacer el ejericio C? Y/N: ");
		if(rc.Leer().equalsIgnoreCase("Y")) {
			EjercicioC();
			EjercicioD();
		}else {
			archivo = new File("..\\numeros.txt");
			ps.println(LeerArchivoBuffered(archivo));
		}
	}

	public void EjercicioE() {
		ps.println("Para hacer este ejercicio, usted debe hacer primero el C.");
		ps.println("¿Desea hacer el ejericio C? Y/N: ");
		if(rc.Leer().equalsIgnoreCase("Y")) {
			EjercicioC();
			EjercicioE();
		}else {
			archivo = new File("..\\numeros.txt");
			ps.println("Se borraran todos los renglones que contengan caracteres numéricos impares: ");
			String texto = "";
			try {
				FileReader fr = new FileReader(archivo);
				BufferedReader br = new BufferedReader(fr);

				String linea = "";

				while((linea = br.readLine()) != null) {
					if(linea.contains(String.valueOf('1')) || linea.contains(String.valueOf('3')) || linea.contains(String.valueOf('5')) || linea.contains(String.valueOf('7')) || linea.contains(String.valueOf('9'))) {
						texto += "";
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
			ps.println("Archivo cambiado: ");
			ps.println(LeerArchivoBuffered(archivo));
		}
	}

	public void EjercicioF() {
		ps.println("Para hacer este ejercicio, usted debe hacer primero el C y el E");
		ps.println("¿Desea hacer el ejericio C y E? Y/N: ");
		if(rc.Leer().equalsIgnoreCase("Y")) {
			EjercicioC();
			EjercicioE();
			EjercicioF();
		}else {
			archivo = new File("..\\..\\primos.dat");
			File ar2 = new File("..\\numeros.txt");
			int contador = 0;
			String texto = "";
			try {
				FileReader fr = new FileReader(ar2);
				BufferedReader br = new BufferedReader(fr);

				String linea = "";

				while((linea = br.readLine()) != null) {
					if(linea == String.valueOf(0) || linea == String.valueOf(1)) {
						texto += "";
					}
					else if(linea == String.valueOf(2)) {
						texto += linea + "\n";
					}else {
						for(int i = 1; i <= Integer.parseInt(linea); i++) {
							if((Integer.parseInt(linea) % i) == 0){
								contador++;
							}
						}
						if(contador <= 2) {
							texto += linea + "\n";
						}else {
							texto += "";
						}
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
ps.println("Primos.dat: ");
ps.println(LeerArchivoBuffered(archivo));
}
}

	public void EjercicioG() {
		archivo = new File("..\\catacteres.dat");
		ps.println("Ingrese 10 palabras que contengan la letra Ñ: ");
		try {
			fw = new FileWriter(archivo);
		}catch (IOException e) {
			e.printStackTrace();
		}
		PrintWriter pw = new PrintWriter(fw);
		String aux1;
		for(int i = 0; i < 10; i++) {
			ps.print("Ingrese la palabra N° " + (i+1) + ": ");
			aux1 = rc.Leer();
			pw.println(aux1);
		}
		try {
			fw.flush();
			pw.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		ps.println("Fichero original: ");
		ps.println(LeerArchivoBuffered(archivo));
		/*Problema a partir de acá*/
		try {
			fw = new FileWriter(archivo);
		}catch (IOException e) {
			e.printStackTrace();
		}
		String texto = "";
		try {
			FileReader fr = new FileReader(archivo);
			BufferedReader br = new BufferedReader(fr);

			String linea = "";
			while((linea = br.readLine()) != null) {
				if(linea.contains(String.valueOf('ñ'))) {
					texto += linea.replace('ñ', 'n');
				}
			}
			br.close();
			fr.close();
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		pw.print(texto);
		try {
			fw.flush();
			pw.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		ps.println("Fichero arreglado: ");
		ps.println(LeerArchivoBuffered(archivo));
	}

	public String LeerArchivoBuffered(File a) {
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
