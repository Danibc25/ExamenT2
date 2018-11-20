
public class Operaciones {
	
	private String tipo;
	private int cantidad;
	private Double precio;

	public Operaciones() {

	}

	public Operaciones(String Tipo, int Cantidad, Double Precio) {
		tipo = Tipo;
		cantidad = Cantidad;
		precio = Precio;

	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Operacion: \nTipo = " + tipo + "\n"+"cantidad = " + cantidad +"\n"+ "precio = " + precio + "]\n\n";
	}
	
}