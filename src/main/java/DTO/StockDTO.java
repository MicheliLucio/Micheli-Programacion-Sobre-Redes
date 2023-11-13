package DTO;

public class StockDTO implements GeneralDTO{
	private int id;
	private String nombre;
	private String descripcion;
	private float precio_compra;
	private float precio_venta;
	private int cant;
	private boolean descontinuado;
	
	public StockDTO() {
		
	}
	
	public StockDTO(String n, String d, float pc, float pv, int c, boolean desc) {
		this.nombre = n;
		this.descripcion = d;
		this.precio_compra = pc;
		this.precio_venta = pv;
		this.cant = c;
		this.descontinuado = desc;
	}
	
	public StockDTO(int id, String n, String d, float pc, float pv, int c, boolean desc) {
		this.id = id;
		this.nombre = n;
		this.descripcion = d;
		this.precio_compra = pc;
		this.precio_venta = pv;
		this.cant = c;
		this.descontinuado = desc;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public float getPrecio_compra() {
		return precio_compra;
	}

	public void setPrecio_compra(float precio_compra) {
		this.precio_compra = precio_compra;
	}

	public float getPrecio_venta() {
		return precio_venta;
	}

	public void setPrecio_venta(float precio_venta) {
		this.precio_venta = precio_venta;
	}

	public int getCant() {
		return cant;
	}

	public void setCant(int cant) {
		this.cant = cant;
	}

	public boolean isDiscontinuado() {
		return descontinuado;
	}

	public void setDiscontinuado(boolean descontinuado) {
		this.descontinuado = descontinuado;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "StockDTO [id=" + id + ", "
				+ "\n NOMBRE =" + nombre +", "
				+ "\n DESCRIPCION =" + descripcion +","
				+ "\n PRECIO-COMPRA =" + precio_compra +","
				+ "\n PRECIO-VENTA =" + precio_venta +","
				+ "\n CANTIDAD =" + cant +","
				+ "\n DESCONTINUADO =" + descontinuado +"]";
	}
	
	
}
