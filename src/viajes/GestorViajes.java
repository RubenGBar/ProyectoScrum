package viajes;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

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
		}
	}
}
