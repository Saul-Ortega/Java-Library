package d;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Console {
	
	/*
	 * OJO!!!
	 * LIMPIAR EL BÚFER CON KEYBOARD.NEXTLINE() SI SE REPITE EL MENSAJE DE ERROR
	 */

	public static String consoleErrorManagementString(Scanner keyboard, String message) {
		/*
		 * MÉTODO PARA LEER POR CONSOLA UN STRING QUE RECIBE POR PARÁMETROS
		 * EL OBJETO SCANNER Y UN STRING QUE ES EL MENSAJE QUE SE IMPRIMIRÁ
		 * POR PANTALLA.
		 * COMPRUEBA QUE EL STRING QUE LEE POR CONSOLA SEA INFERIOR AL TAMAÑO MÁXIMO
		 * Y QUE TODOS LOS CARACTERES SEAN LETRAS.
		 */
		String verifiedString = "";
		boolean keepGoing = true;
		int lenghLimit = 8;
		String errorMessage;
		
		do {
			try {
				keepGoing = true;
				errorMessage = "ERROR: has introducido un formato incorrecto";
				System.out.println(message);
				verifiedString = keyboard.nextLine();
				
				if (verifiedString.length() > lenghLimit) {
					errorMessage = "ERROR: se ha superado el límite de " + lenghLimit + " caracteres";
					keepGoing = false;
				} else if (verifiedString.length() == 0) {
					errorMessage = "ERROR: no se ha introducido ningún dato";
					keepGoing = false;
				} else {
					for (int i = 0; i < verifiedString.length(); i++) {
						if (!Character.isLetter(verifiedString.charAt(i)) && !Character.isSpaceChar(' ')) {
							i = verifiedString.length();
							keepGoing = false;
						}
					}					
				}
			} catch (Exception e) {
				errorMessage = "ERROR: ha surjido una excepción";
				System.out.println(errorMessage);
				keyboard.next();
			}
			
			if (!keepGoing) {
				System.out.println(errorMessage);
			}
			
		} while (!keepGoing);
		
		//keyboard.nextLine(); LIMPIAR EL BÚFER
		
		return verifiedString;
	}
	public static int consoleErrorManagementInt(Scanner keyboard, String message) {
		/*
		 * MÉTODO QUE RECIBE UN OBJETO DE TIPO SCANNER PARA LEER
		 * POR CONSOLA Y OTRO DE TIPO STRING QUE REPRESENTA UN
		 * MENSAJE.
		 * SE CONTROLA QUE EL USUARIO PONGA UN NÚMERO ENTERO.
		 */
		int verifiedInt = 0;
		boolean keepGoing = true;
		String errorMessage;
		
		do {
			try {
				keepGoing = true;
				System.out.println(message);
				verifiedInt = keyboard.nextInt();
			} catch (InputMismatchException e) {
				errorMessage = "ERROR: debes introducir un número";
				System.out.println(errorMessage);
				keepGoing = false;
				keyboard.next();
			} catch (Exception e) {
				errorMessage = "ERROR: ha surjido una excepción";
				System.out.println(errorMessage);
				keepGoing = false;
				keyboard.next();
			}
		} while (!keepGoing);
		
		//keyboard.nextLine(); LIMPIAR EL BÚFER
		
		return verifiedInt;
	}
	public static double consoleErrorManagementDouble(Scanner keyboard, String message) {
		/*
		 * MÉTODO QUE RECIBE UN OBJETO DE TIPO SCANNER PARA LEER
		 * POR CONSOLA Y OTRO DE TIPO STRING QUE REPRESENTA UN
		 * MENSAJE.
		 * SE CONTROLA QUE EL USUARIO PONGA UN NÚMERO CON COMA
		 * FLOTANTE.
		 */
		double verifiedDouble = 0;
		boolean keepGoing = true;
		String errorMessage;
		
		do {
			try {
				keepGoing = true;
				System.out.println(message);
				verifiedDouble = keyboard.nextDouble();
			} catch (InputMismatchException e) {
				errorMessage = "ERROR: debes introducir un número";
				System.out.println(errorMessage);
				keepGoing = false;
				keyboard.next();
			} catch (Exception e) {
				errorMessage = "ERROR: ha surjido una excepción";
				System.out.println(errorMessage);
				keepGoing = false;
				keyboard.next();
			}
		} while (!keepGoing);
		
		//keyboard.nextLine(); LIMPIAR EL BÚFER
		
		return verifiedDouble;
	}
	public static int[] consoleReadArrayOfInt(Scanner keyboard, String message, char divider) {
		/*
		 * MÉTODO QUE RECIBE UN OBJETO DE TIPO SCANNER, OTRO DE TIPO STRING
		 * QUE REPRESENTA UN MENAJE Y OTRO DE TIPO CHAR QUE REPRESENTA EL SEPARADOR
		 * QUE SE VA A USAR.
		 * CONTROLA QUE EL USUARIO NO INTRODUZCA EL SEPARADOR AL INICIO O AL FINAL,
		 * TAMBIÉN QUE NO PONGA EL SEPARADOR 2 VECES SEGUIDAS Y QUE SÓLO SE PONGA EL
		 * SEPARADOR Y LOS DÍGITOS.
		 * LUEGO LO SEPARA EN UN ARRAY DE TIPO STRING Y SE CASTEA A OTRO ARRAY DE
		 * TIPO INT Y LO RETORNA.
		 */
		String readString;
		boolean keepGoing = true;
		String errorMessage = "";
		
		do {
			keepGoing = true;
			System.out.println(message);
			readString = keyboard.nextLine();
			
			for (int i = 1; i < readString.length(); i++) {
				if (readString.charAt(0) == divider || readString.charAt(readString.length() - 1) == divider) {
					keepGoing = false;
					i = readString.length() - 1;
					errorMessage = "ERROR: no puedes introducir el separador al inicio ni al final";
				}
				if (readString.charAt(i - 1) == divider && readString.charAt(i) == divider) {
					keepGoing = false;
					i = readString.length() - 1;
					errorMessage = "ERROR: no puedes introducir 2 o más separadores juntos";
				}
				if (!Character.isDigit(readString.charAt(i)) && readString.charAt(i) != divider) {
					keepGoing = false;
					i = readString.length() - 1;
					errorMessage = "ERROR: has introducido un formato incorrecto";
				}
			}
			
			if (!keepGoing) {
				System.out.println(errorMessage);
			}
			
		} while (!keepGoing);
		
		String stringArray[] = readString.split(Character.toString(divider));
		int intArray[] = new int[stringArray.length];
		
		for (int j = 0; j < stringArray.length; j++) {
			intArray[j] = Integer.parseInt(stringArray[j]);
		}
		
		return intArray;
	}
	public static void printArrayOfInt(int array[]) {
		/*
		 * MÉTODO QUE RECIBE UN ARRAY DE TIPO INT Y SEGÚN EL TAMAÑO
		 * UTILIZA UN FORMATO U OTRO.
		 */
		StringBuffer sb = new StringBuffer("");
		
		if (array.length == 1) {
			sb.append("[" + array[0] + "]");
		} else if (array.length == 2) {
			sb.append("[" + array[0] + ", " + array[1] + "]");
		} else {
			sb.append("[" + array[0]);
			for (int i = 1; i < array.length - 1; i++) {
				sb.append(", " + array[i]);
			}
			sb.append(", " + array[array.length - 1] + "]");
		}
		
		System.out.println(sb.toString());
	}
	public static void printArrayOfString(String array[]) {
		/*
		 * MÉTODO QUE RECIBE UN ARRAY DE TIPO SSTRING Y SEGÚN EL TAMAÑO
		 * UTILIZA UN FORMATO U OTRO.
		 */
		StringBuffer sb = new StringBuffer("");
		
		if (array.length == 1) {
			sb.append("[" + array[0] + "]");
		} else if (array.length == 2) {
			sb.append("[" + array[0] + ", " + array[1] + "]");
		} else {
			sb.append("[" + array[0]);
			for (int i = 1; i < array.length - 1; i++) {
				sb.append(", " + array[i]);
			}
			sb.append(", " + array[array.length - 1] + "]");
		}
		
		System.out.println(sb.toString());
	}
	public static int[][] consoleReadMatrixOfInt(Scanner keyboard, String message, char divider, int rows, int columns) {
		/*
		 * MÉTODO QUE RECIBE UN OBJETO DE TIPO SCANNER, UN STRING
		 * QUE REPRESENTA UN MENSAJE, UN CHAR QUE REPRESENTA EL
		 * SEPARADOR QUE SE USARÁ Y 2 INTS QUE REPRESENTAN EL
		 * TAMAÑO DE LA MATRIZ POR PARÁMETROS.
		 * SE HACEN VARIOS CONTROLES DE ERRORES Y SI SE PASAN
		 * SATISFACTORIAMENTE, SE RETORNA UNA MATRIZ DE TIPO
		 * INT CON LOS DATOS INDICADOS POR EL USUARIO.
		 */
		String readString;
		boolean keepGoing = true;
		String errorMessage = "";
		int intMatrix[][] = new int[rows][columns];
		
		do {
			keepGoing = true;
			System.out.println(message);
			readString = keyboard.nextLine();
			
			for (int i = 1; i < readString.length(); i++) {
				if (readString.charAt(0) == divider || readString.charAt(readString.length() - 1) == divider) {
					keepGoing = false;
					i = readString.length();
					errorMessage = "ERROR: no puedes introducir el separador al inicio ni al final";
				} else if (readString.charAt(i - 1) == divider && readString.charAt(i) == divider) {
					keepGoing = false;
					i = readString.length();
					errorMessage = "ERROR: no puedes introducir 2 o más separadores juntos";
				} else if (!Character.isDigit(readString.charAt(i)) && readString.charAt(i) != divider) {
					keepGoing = false;
					i = readString.length();
					errorMessage = "ERROR: has introducido un formato incorrecto";
				}
			}
			
			if (keepGoing) {
				String stringArray[] = readString.split(Character.toString(divider));
				if (stringArray.length == (rows * columns)) {
					
					int counter = 0;
					
					for (int j = 0; j < rows; j++) {
						for (int x = 0; x < columns; x++) {
							intMatrix[j][x] = Integer.parseInt(stringArray[counter]);
							counter++;
						}
					}
					
					return intMatrix;
				} else {
					keepGoing = false;
					errorMessage = "ERROR: no has introducido los datos correctamente";
				}
			}
			
			if (!keepGoing) {
				System.out.println(errorMessage);
			}
		} while (!keepGoing);
		
		return intMatrix;
	}
	public static String[][] consoleReadMatrixOfString(Scanner keyboard, String message, char divider, int rows, int columns) {
		/*
		 * MÉTODO QUE RECIBE UN OBJETO DE TIPO SCANNER, UN STRING
		 * QUE REPRESENTA UN MENSAJE, UN CHAR QUE REPRESENTA EL
		 * SEPARADOR QUE SE USARÁ Y 2 INTS QUE REPRESENTAN EL
		 * TAMAÑO DE LA MATRIZ POR PARÁMETROS.
		 * SE HACEN VARIOS CONTROLES DE ERRORES Y SI SE PASAN
		 * SATISFACTORIAMENTE, SE RETORNA UNA MATRIZ DE TIPO
		 * STRING CON LOS DATOS INDICADOS POR EL USUARIO.
		 */
		String readString;
		boolean keepGoing = true;
		String errorMessage = "";
		String stringMatrix[][] = new String[rows][columns];
		
		do {
			keepGoing = true;
			System.out.println(message);
			readString = keyboard.nextLine();
			
			for (int i = 1; i < readString.length(); i++) {
				if (readString.charAt(0) == divider || readString.charAt(readString.length() - 1) == divider) {
					keepGoing = false;
					i = readString.length();
					errorMessage = "ERROR: no puedes introducir el separador al inicio ni al final";
				} else if (readString.charAt(i - 1) == divider && readString.charAt(i) == divider) {
					keepGoing = false;
					i = readString.length();
					errorMessage = "ERROR: no puedes introducir 2 o más separadores juntos";
				} else if (!Character.isDigit(readString.charAt(i)) && readString.charAt(i) != divider) {
					keepGoing = false;
					i = readString.length();
					errorMessage = "ERROR: has introducido un formato incorrecto";
				}
			}
			
			if (keepGoing) {
				String stringArray[] = readString.split(Character.toString(divider));
				if (stringArray.length == (rows * columns)) {
					
					int counter = 0;
					
					for (int j = 0; j < rows; j++) {
						for (int x = 0; x < columns; x++) {
							stringMatrix[j][x] = stringArray[counter];
							counter++;
						}
					}
					
					return stringMatrix;
				} else {
					keepGoing = false;
					errorMessage = "ERROR: no has introducido los datos correctamente";
				}
			}
			
			if (!keepGoing) {
				System.out.println(errorMessage);
			}
		} while (!keepGoing);
		
		return stringMatrix;
	}
	public static void printConsoleMatrixOfInt(int matrix[][]) {
		/*
		 * MÉTODO QUE RECIBE UNA MATRIZ DE TIPO INT
		 * POR PARÁMETRO.
		 * SE DECLARA UN STRINGBUFFER Y SE VAN AÑADIENDO
		 * LOS DATOS DE LA MATRIZ MEDIANTE 2 BUCLES FOR,
		 * CUANDO FINALIZA, SE IMPRIME EL RESULTADO.
		 */
		StringBuffer sb = new StringBuffer("");
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (j == matrix[0].length - 1) {
					sb.append(matrix[i][j]);
				} else {
					sb.append(matrix[i][j] + " | ");
				}
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
	public static void printConsoleMatrixOfString(String matrix[][]) {
		/*
		 * MÉTODO QUE RECIBE UNA MATRIZ DE TIPO STRING
		 * POR PARÁMETRO.
		 * SE DECLARA UN STRINGBUFFER Y SE VAN AÑADIENDO
		 * LOS DATOS DE LA MATRIZ MEDIANTE 2 BUCLES FOR,
		 * CUANDO FINALIZA, SE IMPRIME EL RESULTADO.
		 */
		StringBuffer sb = new StringBuffer("");
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (j == matrix[0].length - 1) {
					sb.append(matrix[i][j]);
				} else {
					sb.append(matrix[i][j] + " | ");
				}
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
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
