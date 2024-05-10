package viajes;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * Esta clase se encargará de añadir, eliminar, modificar y consultar los viajes del fichero
 * @author Alonso
 */
public class GestorViajes {
	/**
	 * Almacena todos los viajes del fichero
	 */
	public ArrayList<Viaje> listaViajes;
	
	/**
	 * Se emplea para cargar los datos del fichero
	 */
	private static BufferedReader br;
	
	public void preparar() {
		String linea;
		String[] viajeString;
		try {
			br = new BufferedReader(new FileReader("src/viajes/datosTurismo.txt"));
			while((linea = br.readLine()) != null) {
				viajeString = linea.split("::");
				Viaje viaje = new Viaje(viajeString[0], viajeString[1], viajeString[2]);
				listaViajes.add(viaje);
			}
			
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
