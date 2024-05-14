package viajes;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		
		// GestorViajes gv: crea un nuevo objeto GestorViajes
		GestorViajes gv = new GestorViajes();
		
		// String lugar: lugar de uin viaje
		String lugar;
		
		// String fecha: fecha de un viaje
		String fecha;
		
		// int precio: precio de un viaje
		int precio;
		
		// int opcion: opcion seleccionada por el usuario
		int opcion = 0;
		
		// Inicia el Scanner
		Scanner sc = new Scanner(System.in);
		
		// Do-While: mientras la opcion no sea 5, el programa se seguira ejecutando
		do {
			
			// Muestra el menu y pide al usuario una opcion
			mostrarMenu();
			opcion = sc.nextInt();
			
			// Switch
			switch (opcion) {
			
				// Case 1: muestra la lista de viajes
				case 1 -> {
					System.out.println(gv.listaViajes.toString());
				} // Fin Case 1
				
				// Case 2: añade un viaje
				case 2 -> {
					
					// Pide al usuario un lugar
					System.out.println("Inserta un lugar");
					lugar = sc.nextLine();
					
					// Pide al usuario una fecha
					System.out.println("Inserta una fecha");
					fecha = sc.nextLine();
					
					// Try-Catch: Pide al usuario un precio
					try {
						System.out.println("Inserta un precio");
						precio = sc.nextInt();
					} catch (InputMismatchException e) {
						System.out.println("ERROR: respuesta invalida");
					} finally {
						sc.nextLine();
					} // Fin Try-Catch
					
					// Añade el viaje
					gv.agregarViaje(new Viaje(lugar, fecha, precio));
					
				} // Fin Case 2
				
				// Case 3: elimina un viaje (WIP)
				case 3 -> {
					System.out.println("ERROR: opcion aun no disponible");
				} // Fin Case 3
				
				// Case 4: actualiza un viaje (WIP)
				case 4 -> {
					System.out.println("ERROR: opcion aun no disponible");
				} // Fin Case 4
				
			} // Fin Switch
		} while (opcion != 5); // Fin Do-While
		
		// Muestra un mensaje cerrando el programa
		System.out.println("Cerrando programa...");
		
		// Guarda los archivos en un documento nuevo
		gv.guardar();
		
		// Cierra el Scanner
		sc.close();
		
	}
	
	/**
	 * Funcion que muestra el menu
	 */
	private static void mostrarMenu() {
		System.out.println("Programa de gestion de viajes");
		System.out.println("---------------------------------");
		System.out.println("1. Ver viajes");
		System.out.println("2. Añadir viajes");
		System.out.println("3. Eliminar viajes");
		System.out.println("4. Actualizar viajes");
		System.out.println("5. Salir");
		System.out.println("---------------------------------");
		System.out.println("Elige una opcion");
	}
	
}