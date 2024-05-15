package viajes;

/**
 * Clase que representa la información asociada a un viaje con los métodos para poder actualizar sus
 * datos, obtenerlos y comprobar que dos viajes sean iguales, además de los constructores necesarios
 */
public class Viaje {
	
	/**
	 * Atributo para guardar el lugar del viaje
	 */
	String lugar = "";
	
	/**
	 * Atributo para guardar la fecha del viaje
	 */
	String fecha = "";
	
	/**
	 * Atributo para guardar el precio del viaje
	 */
	int precio = 0;
	
	/**
	 * Constructor para crear objetos con todos sus atributos
	 * @param lugar Será el lugar del viaje
	 * @param fecha La fecha del viaje
	 * @param precio Precio del viaje
	 */
	public Viaje(String lugar, String fecha, int precio) {
		if(lugar != null && !lugar.equals("")) {
			this.lugar = lugar;
		}
		if(fecha != null && fecha.matches("[0-9]{2}/[0-9]{2}/[0-9]{4}")) {
			this.fecha = fecha;
		}
		if(precio > 0) {
			this.precio = precio;
		}
	}

	/**
	 * Constructor para buscar los viajes a modificar y eliminar por el lugar
	 * @param lugar Lugar del viaje a modificar o eliminar
	 */
	public Viaje(String lugar) {
		if(lugar != null && !lugar.equals("")) {
			this.lugar = lugar;
		}
	}
	
	/**
	 * Método para obtener el lugar del viaje
	 * @return Devuele el lugar del viaje
	 */
	public String getLugar() {
		return lugar;
	}
	/**
	 * Método para actualizar el lugar del viaje
	 * @param lugar Nuevo lugar a actualizar
	 */
	public void setLugar(String lugar) {
		if(lugar != null && !lugar.equals("")) {
			this.lugar = lugar;
		}
	}
	/**
	 * Método para obtener la fecha del viaje 
	 * @return Devuelve la fecha del viaje
	 */
	public String getFecha() {
		return fecha;
	}
	/**
	 * Método para actualizar la fecha del viaje
	 * @param fecha Fecha con la que actualizar el viaje
	 */
	public void setFecha(String fecha) {
		if(fecha != null && fecha.matches("[0-9]{2}/[0-9]{2}/[0-9]{4}")) {
			this.fecha = fecha;
		}
	}
	/**
	 * Método para obtener el precio del viaje 
	 * @return Devuelve el precio del viaje
	 */
	public int getPrecio() {
		return precio;
	}
	/**
	 * Método para actualizar el precio del viaje
	 * @param precio Precio con el que actualizar el viaje
	 */
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	
	
	/**
	 * Función para mostrar la información de cada viaje
	 * @return Devuelve una cadena con la información de los viajes
	 */
	@Override
	public String toString() {
		String cadena = "";
		
		cadena += "------------------------------------\n";
		cadena += "Viaje a: " + this.lugar + "\n";
		cadena += "Día: " + this.fecha + "\n";
		cadena += "Precio: " + this.precio + "\n";
		cadena += "------------------------------------\n";
		
		return cadena;
	}
	
	/**
	 * Función para comnparar dos viajes y saber si son iguales
	 * @param o Recibe un objeto que se casteará a uno de tipo viaje para poder comparar dos viajes
	 * @return Devuelve true si la fecha y lugar son iguales y false en caso contrario
	 */
	@Override
	public boolean equals(Object o) {
		boolean iguales = false;
		Viaje v = (Viaje) o;
		
		if(this.fecha.equals(v.fecha) && this.lugar.equals(v.lugar)) {
			iguales = true;
		}
		
		return iguales;
	}

}
