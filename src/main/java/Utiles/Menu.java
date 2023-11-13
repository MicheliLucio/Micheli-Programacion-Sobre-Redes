package Utiles;
import java.io.PrintStream;
import Programa.*;

public class Menu {
	Acciones ac = new Acciones();
	Sincronizacion s = new Sincronizacion();
	ReaderClass r = new ReaderClass();
	static PrintStream ps = new PrintStream(System.out);
	
	public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_MAGENTA = "\u0033[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_RESET = "\u001B[0m";
	
	public Menu() {
		
	}
	
	public void iniciar() {
		s.Synergia(true);
		char op = getMenu();
		switch(op) {
			case '1':
				ac.nuevo();
				getMenu();
				break;
			case '2':
				ac.editar();
				getMenu();
				break;
			case '3':
				ac.discontinuarProd();
				getMenu();
				break;
			case '4':
				ac.select();
				getMenu();
				break;
			case '5':
				mostrarMensaje(ANSI_RED+"SALIENDO DEL PROGRAMA");
				s.Synergia(false);
				System.exit(0);
				break;
			default:
				mostrarMensaje(ANSI_RED+"NUMERO NO VALIDO INTENTE DENUEVO");
				getMenu();
		}
	}
	
	public char getMenu() {
        char op;
        do {
            mostrarMensaje(
            		ANSI_PURPLE + 
                    "MENÚ PRINCIPAL\n\n"+
                    ANSI_GREEN
                    + "[1] AGREGAR UN PRODUCTO\n" +
                    ANSI_CYAN
                    + "[2] EDITAR UN PRODUCTO\n"+
                    ANSI_RED
                    + "[3] DESCONTINUAR UN PRODUCTO\n"+
                    ANSI_YELLOW
                    + "[4] MOSTRAR TODOS LOS PRODUCTOS \n"+
                    ANSI_CYAN
                    + "[5] Salir :c \n" +
                    ANSI_RESET
            );
            op = obtenerOpcion();
        } while (op < '1' || op > '5');

        return op;
    }
	
	public char obtenerOpcion() {
		char op = r.Leer().charAt(0);
    	return op;
    }
	
	public  void mostrarMensaje(String cosaAMostrar){
    	ps.println(cosaAMostrar);
    }

}
