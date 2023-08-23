package principal;

import java.io.IOException;

import dao.EmpleadoDAO;
import dto.DTOfactory;
import dto.empleadoDTO;
import dto.tabla;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//ConnectionProbando DB = new ConnectionProbando();
		
		EmpleadoDAO datos = new EmpleadoDAO();
		
		datos.addEmpleado( (empleadoDTO)DTOfactory.getInstance().getDTO(tabla.EMPLEADO) );
		
	}

}