package Programa;
import DAO.*;
import DTO.StockDTO;

import java.util.LinkedList;

import Conexiones.MotorDB;

public class Sincronizacion {
	private StockDAO sdao = new StockDAO();
	
	public Sincronizacion() {
		
	}
	
	public void Synergia(Boolean entrada) {
		LinkedList<StockDTO> stockNube = this.sdao.getAll(MotorDB.H2);
		LinkedList<StockDTO> stockLocal = this.sdao.getAll(MotorDB.MYSQL);
		if(entrada == true) {
			for(StockDTO sd : stockNube) {
				if(!stockLocal.contains(sd) || stockLocal.isEmpty()) {
					stockLocal.add(sd);
				}
			}
			this.sdao.borrarTodo(MotorDB.MYSQL);
			this.sdao.add(stockLocal, MotorDB.MYSQL);
		}else {
			for(StockDTO sd : stockLocal) {
				if(!stockNube.contains(sd)) {
					stockNube.add(sd);
				}
			}
			this.sdao.borrarTodo(MotorDB.H2);
			this.sdao.add(stockNube, MotorDB.H2);
		}
	}
}
