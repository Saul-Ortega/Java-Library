package d;

import java.util.Scanner;

public class Console {

	public static String consoleErrorManagementString(Scanner keyboard, String message) {
		/*
		 * MÉTODO PARA LEER POR CONSOLA UN STRING QUE RECIBE POR PARÁMETROS
		 * EL OBJETO SCANNER Y UN STRING QUE ES EL MENSAJE QUE SE IMPRIMIRÁ
		 * POR PANTALLA.
		 * COMPRUEBA QUE EL STRING QUE LEE POR CONSOLA SEA INFERIOR AL TAMAÑO MÁXIMO
		 * Y QUE TODOS LOS CARACTERES SEAN LETRAS.
		 */
		String verified_string = "";
		boolean keep_going = true;
		int length_limit = 8;
		String error_message;
		
		do {
			try {
				keep_going = true;
				error_message = "ERROR: has introducido un formato incorrecto";
				System.out.println(message);
				verified_string = keyboard.nextLine();
				
				if (verified_string.length() > length_limit) {
					error_message = "ERROR: se ha superado el límite de " + length_limit + " caracteres";
					keep_going = false;
				} else {
					for (int i = 0; i < verified_string.length(); i++) {
						if (!Character.isLetter(verified_string.charAt(i))) {
							i = verified_string.length();
							keep_going = false;
						}
					}
				}
			} catch (Exception e) {
				error_message = "ERROR: ha surjido una excepción";
				System.out.println(error_message);
				keyboard.next();
			}
			
			if (!keep_going) {
				System.out.println(error_message);
			}
			
		} while (!keep_going);
		
		return verified_string;
	}
	public static void printFinishProgram() {
		/*
		 * MÉTODO QUE INDICA AL USUARIO QUE EL
		 * PROGRAMA HA FINALIZADO.
		 */
		System.out.println("***********************************");
		System.out.println("PROGRAMA FINALIZADO");
		System.out.println("***********************************");
	}
	
}
