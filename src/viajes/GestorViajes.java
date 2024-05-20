package viajes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

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
	 * Se encarga de conseguir el viaje sobre el que el usuario quiere operar alguna accion destructiva
	 * (ediciones y borrados)
	 * @param lugar
	 * @return lugar elegido por el usuario
	 */
	public Viaje elegirViaje(String lugar) {
		ArrayList<Viaje> viajesLugar = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		// usamos esta variable para iterar sobre listaViajes y agregar los viajes a viajesLugar
		Viaje temp;
		// almacena la opcion que ha seleccionado el usuario
		int option = -1;
		
		for(int i = 0; i < listaViajes.size(); i++) {
			temp = listaViajes.get(i);
			if(temp.lugar.equals(lugar)) {
				viajesLugar.add(temp);
				System.out.println(i + ". Lugar: " + temp.lugar + " Fecha: " + temp.fecha + " Precio: " + temp.precio + "€");
			}
		}
		
		if(viajesLugar.size() >= 2) {
			do {
				System.out.println("Introduzca el índice del viaje a seleccionar:");
				try {
					option = sc.nextInt();
					sc.nextLine();
				}catch(IllegalArgumentException e) {
					System.err.println("Tipo de dato incorrecto.");
					sc.nextLine();
				}
				
			}while(option < 0 || option > viajesLugar.size());
		}else {
			option = 0;
		}
		sc.close();
		return viajesLugar.get(option);
	}
	
	/**
	 * Borra un viaje de los que tienen como destino el lugar pasado por parámetros
	 * @param viaje
	 * @return true si el borrado ha sido correcto y false si no se ha podido borrar
	 */
	public boolean eliminarViaje(String lugar) {
		Viaje viajeABorrar = elegirViaje(lugar);
		boolean eliminado = false;
		
		eliminado = listaViajes.remove(viajeABorrar);
		
		return eliminado;
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
