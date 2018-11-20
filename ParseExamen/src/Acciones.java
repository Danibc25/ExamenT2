import java.util.ArrayList;

public class Acciones {
		
	private String nombre;
	private ArrayList<Operaciones> operacion;
	
	
	public Acciones() {}
	
	public Acciones(String Nombre, ArrayList<Operaciones> Operaciones) {
		
		nombre = Nombre;
		operacion = Operaciones;
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Operaciones> getOperacion() {
		return operacion;
	}

	public void setOperacion(ArrayList<Operaciones> operacion) {
		this.operacion = operacion;
	}

	
	public String print() {
		return "Acciones [nombre=" + nombre + "\n" + operacion;
	}
	
}
