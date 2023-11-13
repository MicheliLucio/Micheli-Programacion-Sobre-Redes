package DAO;
import java.util.LinkedList;
import DTO.*;
import Conexiones.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StockDAO implements GeneralDAO<StockDTO> {
	ConnectionFactory cf = ConnectionFactory.getInstance();
	final Logger LOG = Logger.getLogger(StockDAO.class.getName());

	public int add(StockDTO stock) {
		PreparedStatement ps = null;
		Connection conn = null;
		
		try {
			conn = cf.getConnection(MotorDB.MYSQL);
			
			String sql = "INSERT INTO stock(nombre, descripcion, precio_compra, precio_venta, cant, discontinuado) VALUES (?, ?, ?, ?, ?, ?)";
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, stock.getNombre());
			ps.setString(2, stock.getDescripcion());
			ps.setFloat(3, stock.getPrecio_compra());
			ps.setFloat(4, stock.getPrecio_venta());
			ps.setInt(5, stock.getCant());
			ps.setBoolean(6, stock.isDiscontinuado());
			
			return ps.executeUpdate();
		}catch (SQLException ex) {
			LOG.log(Level.SEVERE,
					"INDICE CON ERROR:".concat(String.valueOf(stock.getNombre())).concat(" - TABLA: STOCK"), ex);
		} finally {
			try {
				ps.close();
				conn.close();
			} catch (SQLException ex) {
				LOG.log(Level.SEVERE, null, ex);
			}
		}
		
		return 0;
	}

	public int add(LinkedList<StockDTO> lista, MotorDB tipo) {
		PreparedStatement ps = null;
		Connection conn = null;
		
		try {
			conn = cf.getConnection(tipo);
			
			for(StockDTO stock : lista) {
				String sql = "INSERT INTO stock(nombre, descripcion, precio_compra, precio_venta, cant, discontinuado) VALUES (?, ?, ?, ?, ?, ?)";
				ps = conn.prepareStatement(sql);
				ps.setString(1, stock.getNombre());
				ps.setString(2, stock.getDescripcion());
				ps.setFloat(3, stock.getPrecio_compra());
				ps.setFloat(4, stock.getPrecio_venta());
				ps.setInt(5, stock.getCant());
				ps.setBoolean(6, stock.isDiscontinuado());
			}
			
			return ps.executeUpdate();
		}catch (SQLException ex) {
			LOG.log(Level.SEVERE, null, ex);
		} finally {
			try {
				ps.close();
				conn.close();
			} catch (SQLException ex) {
				LOG.log(Level.SEVERE, null, ex);
			}
		}
		
		return 0;
	}
	
	@Override
	public int add(LinkedList<StockDTO> lista) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int borrar(StockDTO aBorrar) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int borrar(LinkedList<StockDTO> aBorrar) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public int borrarTodo(MotorDB tipo) {
		PreparedStatement ps = null;
		Connection conn = null;

		try {
			String sql = "DELETE FROM stock";

			conn = cf.getConnection(tipo);
			ps = conn.prepareStatement(sql);

			return ps.executeUpdate();
		} catch (SQLException ex) {
			LOG.log(Level.SEVERE, null, ex);
		} finally {
			try {
				ps.close();
				conn.close();
			} catch (SQLException ex) {
				LOG.log(Level.SEVERE, null, ex);
			}
		}
		return -1;
	}

	public int update(StockDTO registro) {
		PreparedStatement ps = null;
		Connection conn = null;

		try {
			String consulta = "UPDATE stock SET nombre=? , descripcion=? , precio_compra=?, precio_venta=?, cant=? WHERE id=?";

			conn = cf.getConnection(MotorDB.MYSQL);
			ps = conn.prepareStatement(consulta);

			ps.setString(1, registro.getNombre());
			ps.setString(2, registro.getDescripcion());
			ps.setFloat(3, registro.getPrecio_compra());
			ps.setFloat(4, registro.getPrecio_venta());
			ps.setInt(5, registro.getCant());
			ps.setInt(6, registro.getId());

			return ps.executeUpdate();
		} catch (SQLException ex) {
			LOG.log(Level.SEVERE,
					"INDICE CON ERROR:".concat(String.valueOf(registro.getId())).concat(" - TABLA: STOCK"), ex);
		} finally {
			try {
				ps.close();
				conn.close();
			} catch (SQLException ex) {
				LOG.log(Level.SEVERE, null, ex);
			}
		}
		return -1;
	}
	
	public int discontinuar(StockDTO registro) {
		PreparedStatement ps = null;
		Connection conn = null;

		try {
			String consulta = "UPDATE stock SET discontinuado=? WHERE id=?";

			conn = cf.getConnection(MotorDB.MYSQL);
			ps = conn.prepareStatement(consulta);

			ps.setBoolean(1, registro.isDiscontinuado());
			ps.setInt(2, registro.getId());

			return ps.executeUpdate();
		} catch (SQLException ex) {
			LOG.log(Level.SEVERE,
					"INDICE CON ERROR:".concat(String.valueOf(registro.getId())).concat(" - TABLA: STOCK"), ex);
		} finally {
			try {
				ps.close();
				conn.close();
			} catch (SQLException ex) {
				LOG.log(Level.SEVERE, null, ex);
			}
		}
		return -1;
	}

	public int update(LinkedList<StockDTO> registro) {
		// TODO Auto-generated method stub
		return 0;
	}

	public LinkedList<StockDTO> getAll(MotorDB motomoto) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		LinkedList<StockDTO> aux = new LinkedList<StockDTO>();

		String sql = "SELECT * FROM stock";

		try {
			conn = cf.getConnection(motomoto);
			ps = conn.prepareStatement(sql);

			rs = ps.executeQuery();

			while (rs.next()) {
				aux.add(new StockDTO(rs.getInt("id"), rs.getString("nombre"), rs.getString("descripcion"), rs.getFloat("precio_compra"),
						rs.getFloat("precio_venta"), rs.getInt("cant"), rs.getBoolean("discontinuado"))); 
			}
		} catch (SQLException e) {
			LOG.log(Level.SEVERE, null, e);
		} finally {
			cerrarConexiones(rs, ps, conn);
		}

		return aux;
	}
	
	public StockDTO get(int id) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM empleado WHERE id=?";

		try {
			conn = cf.getConnection(MotorDB.MYSQL);
			ps = conn.prepareStatement(sql);

			ps.setInt(1, id);

			rs = ps.executeQuery();

			while (rs.next()) {
				return (StockDTO) DTOFactory.getInstance().getDTO(Tabla.STOCK, rs);
			}
		} catch (SQLException e) {
			LOG.log(Level.SEVERE, null, e);
		} finally {
			cerrarConexiones(rs, ps, conn);
		}
		
		return null;
	}
	
	@Override
	public LinkedList<StockDTO> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	private void cerrarConexiones(ResultSet rs, PreparedStatement ps, Connection conn) {
		try {
			if (rs != null)
				rs.close();
			if (ps != null)
				ps.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			LOG.log(Level.SEVERE, null, e);
		}
	}
}

