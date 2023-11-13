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
		ps.println("Ingrese el nombre del producto: ");
		String n = r.Leer();
		ps.println("Ingrese la descripción del producto: ");
		String d = r.Leer();
		ps.println("Ingrese el Precio de Compra del producto: ");
		float pc = Float.parseFloat(r.Leer());
		ps.println("Ingrese el Precio de Venta del producto: ");
		float pv = Float.parseFloat(r.Leer());
		ps.println("Ingrese la cantidad de productos en stock: ");
		int c = Integer.parseInt(r.Leer());
		boolean disc = false;
		StockDTO s = new StockDTO(n, d, pc, pv, c, disc);
		StockDAO sdao = new StockDAO();
		sdao.add(s);
		ps.println("Producto agregado.");
	}
	
	public void editar() {
		StockDAO sdao = new StockDAO();
		ps.println("Ingrese el ID del producto que desea editar: ");
		int idOg = Integer.parseInt(r.Leer());
		StockDTO s = sdao.get(idOg);
		ps.println("Edite el nombre del producto. Nombre anterior ("+ s.getNombre() +")");
		String nuevoN = r.Leer();
		s.setNombre(nuevoN);
		ps.println("Edite la descripción del producto. Desc anterior ("+ s.getDescripcion() +")");
		String nuevoD = r.Leer();
		s.setDescripcion(nuevoD);
		ps.println("Edite el precio de compra del producto. Precio anterior ("+ s.getPrecio_compra() +")");
		float npc = Float.parseFloat(r.Leer());
		s.setPrecio_compra(npc);
		ps.println("Edite el precio de venta del producto. Precio anterior ("+ s.getPrecio_venta() +")");
		float npv = Float.parseFloat(r.Leer());
		s.setPrecio_venta(npv);
		ps.println("Edite la cantidad del producto. Cantidad anterior ("+ s.getCant() +")");
		int nCant = Integer.parseInt(r.Leer());
		s.setCant(nCant);
		sdao.update(s);
		ps.println("Producto editado.");
	}
	
	public void discontinuarProd() {
		StockDAO sdao = new StockDAO();
		ps.println("Ingrese el ID del producto que desea discontinuar: ");
		int idOg = Integer.parseInt(r.Leer());
		StockDTO s = sdao.get(idOg);
		s.setDiscontinuado(true);
		sdao.discontinuar(s);
		ps.println("Producto discontinuado.");
	}
	
	public void select() {
		ps.println("A continuación, todos los productos: ");
		StockDAO sdao = new StockDAO();
		LinkedList<StockDTO> aux = sdao.getAll(MotorDB.MYSQL);
		for(StockDTO s : aux) {
			ps.println(s.toString());
		}
	}
}
