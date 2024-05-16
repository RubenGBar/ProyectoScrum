package viajes;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {

	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_RESET = "\u001B[0m";
	
	public static void main(String[] args) {
		
		// GestorViajes gv: crea un nuevo objeto GestorViajes
		GestorViajes gv = new GestorViajes();
		
		// String lugar: lugar de uin viaje
		String lugar;
		
		// String fecha: fecha de un viaje
		String fecha;
		
		// int precio: precio de un viaje
		int precio = 0;
		
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
					gv.listarViajes();
				} // Fin Case 1
				
				// Case 2: añade un viaje
				case 2 -> {
					
					// Pide al usuario un lugar
					System.out.println(ANSI_BLUE + "╔════════════════════════════════════╗" + ANSI_RESET);
					System.out.println(ANSI_BLUE + "║          Inserta un lugar          ║" + ANSI_RESET);
					System.out.println(ANSI_BLUE + "╚════════════════════════════════════╝" + ANSI_RESET);
					sc.nextLine();
					lugar = sc.nextLine();
					
					// Pide al usuario una fecha
					System.out.println(ANSI_BLUE + "╔════════════════════════════════════╗" + ANSI_RESET);
					System.out.println(ANSI_BLUE + "║         Inserta una fecha          ║" + ANSI_RESET);
					System.out.println(ANSI_BLUE + "╚════════════════════════════════════╝" + ANSI_RESET);
					fecha = sc.nextLine();
					
					// Try-Catch: Pide al usuario un precio
					try {
						System.out.println(ANSI_BLUE + "╔════════════════════════════════════╗" + ANSI_RESET);
						System.out.println(ANSI_BLUE + "║         Inserta un precio          ║" + ANSI_RESET);
						System.out.println(ANSI_BLUE + "╚════════════════════════════════════╝" + ANSI_RESET);
						precio = sc.nextInt();
					} catch (InputMismatchException e) {
						System.out.println(ANSI_RED + "╔════════════════════════════════════╗" + ANSI_RESET);
						System.out.println(ANSI_RED + "║      ERROR: respuesta invalida     ║" + ANSI_RESET);
						System.out.println(ANSI_RED + "╚════════════════════════════════════╝" + ANSI_RESET);
					} finally {
						sc.nextLine();
					} // Fin Try-Catch
					
					// Añade el viaje (necesita comprobacion)
					gv.agregarViaje(new Viaje(lugar, fecha, precio));
					
				} // Fin Case 2
				
				// Case 3: elimina un viaje
				case 3 -> {
					System.out.println(ANSI_BLUE + "╔════════════════════════════════════╗" + ANSI_RESET);
					System.out.println(ANSI_BLUE + "║          Inserta un lugar          ║" + ANSI_RESET);
					System.out.println(ANSI_BLUE + "╚════════════════════════════════════╝" + ANSI_RESET);
					sc.nextLine();
					lugar = sc.nextLine();
					gv.eliminarViaje(lugar);
				} // Fin Case 3
				
				// Case 4: actualiza un viaje (WIP)
				case 4 -> {
					System.out.println(ANSI_RED + "╔════════════════════════════════════╗" + ANSI_RESET);
					System.out.println(ANSI_RED + "║   ERROR: opcion aun no disponible  ║" + ANSI_RESET);
					System.out.println(ANSI_RED + "╚════════════════════════════════════╝" + ANSI_RESET);
				} // Fin Case 4
				
			} // Fin Switch
		} while (opcion != 5); // Fin Do-While
		
		// Muestra un mensaje cerrando el programa
		System.out.println(ANSI_GREEN + "╔════════════════════════════════════╗" + ANSI_RESET);
		System.out.println(ANSI_GREEN + "║        Cerrando programa...        ║" + ANSI_RESET);
		System.out.println(ANSI_GREEN + "╚════════════════════════════════════╝" + ANSI_RESET);
		
		// Guarda los archivos en un documento nuevo
		gv.guardar();
		
		// Cierra el Scanner
		sc.close();
		
	}
	
	/**
	 * Funcion que muestra el menu
	 */
	private static void mostrarMenu() {
		System.out.println(ANSI_RED + "╔════════════════════════════════════╗" + ANSI_RESET);
		System.out.println(ANSI_RED + "║    Programa de gestion de viajes   ║" + ANSI_RESET);
		System.out.println(ANSI_RED + "╠════════════════════════════════════╣" + ANSI_RESET);
		System.out.println(ANSI_GREEN + "║           1. Ver viajes            ║" + ANSI_RESET);
		System.out.println(ANSI_GREEN + "║          2. Añadir viajes          ║" + ANSI_RESET);
		System.out.println(ANSI_GREEN + "║         3. Eliminar viajes         ║" + ANSI_RESET);
		System.out.println(ANSI_GREEN + "║        4. Actualizar viajes        ║" + ANSI_RESET);
		System.out.println(ANSI_GREEN + "║              5. Salir              ║" + ANSI_RESET);
		System.out.println(ANSI_BLUE + "╠════════════════════════════════════╣" + ANSI_RESET);
		System.out.println(ANSI_BLUE + "║          Elige una opcion          ║" + ANSI_RESET);
		System.out.println(ANSI_BLUE + "╚════════════════════════════════════╝" + ANSI_RESET);
	}
	
}