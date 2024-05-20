package viajes;

/**
 * Clase que representa la informacion asociada a un viaje con los metodos para
 * poder actualizar sus datos, obtenerlos y comprobar que dos viajes sean
 * iguales, ademas de los constructores necesarios
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
	double precio = 0;

	/**
	 * Constructor para crear objetos con todos sus atributos
	 * 
	 * @param lugar  Sera el lugar del viaje
	 * @param fecha  La fecha del viaje
	 * @param precio Precio del viaje
	 */
	public Viaje(String lugar, String fecha, double precio) {
		if (lugar != null && !lugar.equals("")) {
			this.lugar = lugar;
		}
		if (validarFecha(fecha)) {
			this.fecha = fecha;
		}
		if (precio > 0) {
			this.precio = precio;
		}
	}

	/**
	 * Funcion de validacion para validar la fecha
	 * 
	 * @param fecha fecha a validar
	 * @return si la fecha se ha podido validar o no
	 */
	public boolean validarFecha(String fecha) {

		// boolean isTrue: comprobante de si la fecha es valida o no
		boolean isTrue = false;

		// int dias: dias de la fecha
		int dias = 0;

		// int mes: mes de la fecha
		int mes = 0;

		// int anio: anio de la fecha
		int anio = 0;

		// If: Valida los dias
		if (validarNumero(fecha, 1)) {
			dias = Integer.parseInt(fecha.substring(0, 2));
		} // Fin If

		// If: Valida el mes
		if (validarNumero(fecha, 2)) {
			mes = Integer.parseInt(fecha.substring(3, 5));
		} // Fin If

		// If: Valida el anio
		if (validarNumero(fecha, 3)) {
			anio = Integer.parseInt(fecha.substring(6, 10));
		} // Fin If

		// If: si la fecha no es vacia, o esta en el formato 00/00/0000 o sus fechas
		// sean validas, isTrue sera valido
		if (fecha != null && !fecha.equals("") && fecha.matches("[0-9]{2}/[0-9]{2}/[0-9]{4}") && dias >= 1 && dias <= 31
				&& mes >= 1 && mes <= 12 && anio >= 1901) {
			isTrue = true;
		} // Fin If

		// Devuelve isTrue
		return isTrue;

	}

	/**
	 * Funcion validarNumero: valida un numero de la fecha
	 * 
	 * @param fecha  fecha a analizar
	 * @param opcion parte de la fecha a analizar
	 * @return si el numero es valido o no
	 */
	private boolean validarNumero(String fecha, int opcion) {

		// boolean numValido: comprobante de si un numero es valido o no
		boolean numValido = false;

		// int dias: dias de la fecha
		try {
			
			// Switch: por cada opcion, se analizara cierta zona de la puerta
			switch (opcion) {

			// Case 1: analiza el dia
			case 1 -> {
				Integer.parseInt(fecha.substring(0, 2));
			} // Fin Case 1

			// Case 2: analiza el mes
			case 2 -> {
				Integer.parseInt(fecha.substring(3, 5));
			} // Fin Case 2
			
			// Case 3: analiza el anio
			case 3 -> {
				Integer.parseInt(fecha.substring(6, 10));
			} // Fin Case 3

			} // Fin Switch
			
			// numValido pasa a ser true
			numValido = true;
			
		} catch (NumberFormatException e) {
			
			// Muestra un mensaje de error
			System.out.println(Principal.ANSI_RED + "╔════════════════════════════════════╗" + Principal.ANSI_RESET);
			System.out.println(Principal.ANSI_RED + "║       ERROR: numero invalido       ║" + Principal.ANSI_RESET);
			System.out.println(Principal.ANSI_RED + "╚════════════════════════════════════╝" + Principal.ANSI_RESET);
			
		} // Fin Try-Catch

		// Devuelve numValido
		return numValido;

	}

	/**
	 * Constructor para buscar los viajes a modificar y eliminar por el lugar
	 * 
	 * @param lugar Lugar del viaje a modificar o eliminar
	 */
	public Viaje(String lugar) {
		if (lugar != null && !lugar.equals("")) {
			this.lugar = lugar;
		}
	}

	/**
	 * Metodo para obtener el lugar del viaje
	 * 
	 * @return Devuele el lugar del viaje
	 */
	public String getLugar() {
		return lugar;
	}

	/**
	 * Metodo para actualizar el lugar del viaje
	 * 
	 * @param lugar Nuevo lugar a actualizar
	 */
	public void setLugar(String lugar) {
		if (lugar != null && !lugar.equals("")) {
			this.lugar = lugar;
		}
	}

	/**
	 * Metodo para obtener la fecha del viaje
	 * 
	 * @return Devuelve la fecha del viaje
	 */
	public String getFecha() {
		return fecha;
	}

	/**
	 * Metodo para actualizar la fecha del viaje
	 * 
	 * @param fecha Fecha con la que actualizar el viaje
	 */
	public void setFecha(String fecha) {
		if (fecha != null && fecha.matches("[0-9]{2}/[0-9]{2}/[0-9]{4}")) {
			this.fecha = fecha;
		}
	}

	/**
	 * Metodo para obtener el precio del viaje
	 * 
	 * @return Devuelve el precio del viaje
	 */
	public double getPrecio() {
		return precio;
	}

	/**
	 * Metodo para actualizar el precio del viaje
	 * 
	 * @param precio Precio con el que actualizar el viaje
	 */
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	/**
	 * Funcion para mostrar la informacion de cada viaje
	 * @return Devuelve una cadena con la informacion de los viajes
	 */
	@Override
	public String toString() {
		String cadena = "";

		cadena += "══════════════════════════════════════\n";
		cadena += "Viaje a: " + this.lugar + "\n";
		cadena += "Dia: " + this.fecha + "\n";
		cadena += "Precio: " + this.precio + "\n";
		cadena += "══════════════════════════════════════\n";

		return cadena;
	}
	
	/**
	 * Función para comnparar dos viajes y saber si son iguales
	 * @param o Recibe un objeto que se casteara a uno de tipo viaje para poder comparar dos viajes
	 * @return Devuelve true si la fecha y lugar son iguales y false en caso contrario
	 */
	@Override
	public boolean equals(Object o) {
		boolean iguales = false;
		Viaje v = (Viaje) o;

		if (this.fecha.equals(v.fecha) && this.lugar.equals(v.lugar)) {
			iguales = true;
		}

		return iguales;
	}

}
