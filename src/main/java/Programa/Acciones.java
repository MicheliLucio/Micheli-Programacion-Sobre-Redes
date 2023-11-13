package Programa;
import DTO.StockDTO;
import DAO.StockDAO;
import java.util.LinkedList;
import Conexiones.MotorDB;
import java.io.PrintStream;
import Utiles.*;

public class Acciones {
	ReaderClass r = new ReaderClass();
	PrintStream ps = new PrintStream(System.out);
	
	public Acciones() {
		
	}
	
	public void nuevo() {
		ps.println("INGRESAR EL NOMBRE DEL PRODUCTO: ");
		String n = r.Leer();
		ps.println("INGRESAR LA DESCRIPCION DEL PRODUCTO: ");
		String d = r.Leer();
		ps.println("INGRESAR EL PRECIO DE COMPRA DEL PRODUCTO: ");
		float pc = Float.parseFloat(r.Leer());
		ps.println("INGRESAR EL PRECIO DE VENTA DEL PRODUCTO: ");
		float pv = Float.parseFloat(r.Leer());
		ps.println("INGRESAR EL STOCK DEL PRODUCTO: ");
		int c = Integer.parseInt(r.Leer());
		boolean disc = false;
		StockDTO s = new StockDTO(n, d, pc, pv, c, disc);
		StockDAO sdao = new StockDAO();
		sdao.add(s);
		ps.println("Producto agregado.");
	}
	
	public void editar() {
		StockDAO sdao = new StockDAO();
		ps.println("INGRESAR EL ID DEL PRODUCTO: ");
		int idOg = Integer.parseInt(r.Leer());
		StockDTO s = sdao.get(idOg);
		ps.println("EDITAR NOMBRE DEL PRODUCTO. Nombre anterior ("+ s.getNombre() +")");
		String nuevoN = r.Leer();
		s.setNombre(nuevoN);
		ps.println("EDITAR LA DESCRIPCION DEL PRODUCTO. Desc anterior ("+ s.getDescripcion() +")");
		String nuevoD = r.Leer();
		s.setDescripcion(nuevoD);
		ps.println("EDITAR EL PRECIO DE COMPRA DEL PRODUCTO. Precio anterior ("+ s.getPrecio_compra() +")");
		float npc = Float.parseFloat(r.Leer());
		s.setPrecio_compra(npc);
		ps.println("EDITAR EL PRECIO DE VENTA DEL PRODUCTO. Precio anterior ("+ s.getPrecio_venta() +")");
		float npv = Float.parseFloat(r.Leer());
		s.setPrecio_venta(npv);
		ps.println("EDITAR LA CANTIDAD EN STOCK DEL PRODUCTO. Cantidad anterior ("+ s.getCant() +")");
		int nCant = Integer.parseInt(r.Leer());
		s.setCant(nCant);
		sdao.update(s);
		ps.println("PRODUCTO EDITADO.");
	}
	
	public void discontinuarProd() {
		StockDAO sdao = new StockDAO();
		ps.println("INGRESAR LA ID DEL PRODUCTO QUE QUIERE DESCONTINUAR: ");
		int idOg = Integer.parseInt(r.Leer());
		StockDTO s = sdao.get(idOg);
		s.setDiscontinuado(true);
		sdao.discontinuar(s);
		ps.println("PRODUCTO DESCONTINUADO.");
	}
	
	public void select() {
		ps.println("TODOS LOS PRODUCTOS: ");
		StockDAO sdao = new StockDAO();
		LinkedList<StockDTO> aux = sdao.getAll(MotorDB.MYSQL);
		for(StockDTO s : aux) {
			ps.println(s.toString());
		}
	}
}
