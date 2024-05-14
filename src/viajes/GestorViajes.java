package viajes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.io.FileNotFoundException;

/**
 * Esta clase se encargará de añadir, eliminar, modificar y consultar los viajes del fichero
 * @author Alonso
 */
public class GestorViajes {
	/**
	 * Almacena todos los viajes del fichero
	 */
	public ArrayList<Viaje> listaViajes = new ArrayList<>();
	
	/**
	 * Se emplea para cargar los datos del fichero
	 */
	private static BufferedReader br;
	
	/**
	 * Se emplea para cargar los datos de la lista de viajes a un fichero
	 */
	private static BufferedWriter wr;
	
	/**
	 * Se encarga de poblar el ArrayList con los viajes del fichero
	 */
	public void preparar() {
		String linea;
		// almacena los valores almacenados en una línea temporalmente
		String[] viajeString;
		try {
			// acceso al fichero
			br = new BufferedReader(new FileReader("src/viajes/datosTurismo.txt"));
			// recorremos el fichero y vamos agregando los viajes a listaViajes
			while((linea = br.readLine()) != null) {
				viajeString = linea.split("::");
				Viaje viaje = new Viaje(viajeString[0], viajeString[1], Integer.parseInt(viajeString[2]));
				listaViajes.add(viaje);
			}
			
			br.close();
		} catch (FileNotFoundException e) {
			System.err.println("No se ha encontrado el fichero de viajes.");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.err.println("No se ha podido acceder a la lista de viajes: " + e.getMessage());
		}
	}
	
	/**
	 * Imprime por pantalla todos los viajes registrados en la lista de viajes
	 */
	public void listarViajes() {
		for(Viaje viaje: listaViajes) {
			System.out.println(viaje);
		}
	}
	
	/**
	 * Agrega un viaje a la lista
	 * @param viaje
	 * @return true si se ha podido agregar
	 */
	public void agregarViaje(Viaje viaje) {
		if(!listaViajes.contains(viaje)) {
			listaViajes.add(viaje);
		}
	}
	
	/**
	 * Se encarga de almacenar en el archivo turismo.txt la lista de viajes
	 * */
	public void guardar() {
		try {
			wr = new BufferedWriter(new FileWriter("src/viajes/turismo.txt"));
			for(Viaje viaje : listaViajes) {
				wr.write(viaje.getLugar() + "::" + viaje.getFecha() + "::" + viaje.getPrecio());
			}
			wr.flush();
			wr.close();
		}catch(Exception e) {
			System.err.println("Error al guardar la lista de viajes: " + e.getMessage());
		}
	}
	
	
	/**
	 * Constructor vacío
	 */
	public GestorViajes () {
		preparar();
	}
}
