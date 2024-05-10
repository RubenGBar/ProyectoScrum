package viajes;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		
		int opcion = 0;
		
		Scanner sc = new Scanner(System.in);
		
		do {
			mostrarMenu();
			opcion = sc.nextInt();
			
			switch (opcion) {
				case 1 -> {
					// Case 1
				}
				
				case 2 -> {
					// Case 2
				}
				
				case 3 -> {
					// Case 3
				}
				
				case 4 -> {
					// Case 4
				}
			}
		} while (opcion != 5);
		
		System.out.println("Cerrando programa...");
		
		// Aqui se tendria que mandar al programa a que actualice el fichero
		
		sc.close();
		
	}
	
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