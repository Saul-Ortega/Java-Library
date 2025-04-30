package d;

import java.time.LocalDate;

import javax.swing.JOptionPane;

public class Pane {

	public static String paneErrorManagementString(String message) {
		/*
		 * MÉTODO PARA LEER POR CONSOLA UN STRING QUE RECIBE POR PARÁMETROS
		 * EL OBJETO SCANNER Y UN STRING QUE ES EL MENSAJE QUE SE IMPRIMIRÁ
		 * POR UN PANEL.
		 * COMPRUEBA QUE EL STRING QUE LEE POR PANEL SEA INFERIOR AL TAMAÑO MÁXIMO
		 * Y QUE TODOS LOS CARACTERES SEAN LETRAS.
		 */
		String verifiedString = "";
		boolean keepGoing = true;
		int lengthLimit = 8;
		String errorMessage;
		
		do {
			try {
				keepGoing = true;
				errorMessage = "ERROR: has introducido un formato incorrecto";
				verifiedString = JOptionPane.showInputDialog(null, message);
				
				if (verifiedString.length() > lengthLimit) {
					errorMessage = "ERROR: se ha superado el límite de " + lengthLimit + " caracteres";
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
				keepGoing = false;
			}
			
			if (!keepGoing) {
				JOptionPane.showMessageDialog(null, errorMessage);
			}
			
		} while (!keepGoing);
		
		return verifiedString;
	}
	public static int paneErrorManagementInt(String message) {
		/*
		 * MÉTODO QUE RECIBE UN OBJETO DE TIPO SCANNER PARA LEER
		 * POR PANEL Y OTRO DE TIPO STRING QUE REPRESENTA UN
		 * MENSAJE.
		 * SE CONTROLA QUE EL USUARIO PONGA UN NÚMERO ENTERO.
		 */
		String verifiedString = "";
		int verifiedInt = 0;
		boolean keepGoing = true;
		String errorMessage = "";
		
		do {
			try {
				keepGoing = true;
				verifiedString = JOptionPane.showInputDialog(null, message);
				
				for (int i = 0; i < verifiedString.length(); i++) {
					if (!Character.isDigit(verifiedString.charAt(i))) {
						errorMessage = "ERROR: debes introducir números";
						keepGoing = false;
						i = verifiedString.length();
					}
				}
			} catch (NullPointerException e) {
				errorMessage = "ERROR: no puedes cerrar esta ventana";
				keepGoing = false;
			} catch (Exception e) {
				errorMessage = "ERROR: ha surjido una excepción";
				keepGoing = false;
			}
			
			if (!keepGoing) {
				JOptionPane.showMessageDialog(null, errorMessage);
			} else {
				verifiedInt = Integer.parseInt(verifiedString);
			}
		} while (!keepGoing);
		
		return verifiedInt;
	}
	public static double paneErrorManagementDouble(String message) {
		/*
		 * MÉTODO QUE RECIBE UN OBJETO DE TIPO SCANNER PARA LEER
		 * POR JOPTIONPANE Y OTRO DE TIPO STRING QUE REPRESENTA UN
		 * MENSAJE.
		 * SE CONTROLA QUE EL USUARIO PONGA UN NÚMERO CON COMA
		 * FLOTANTE.
		 */
		String verifiedString = "";
		double verifiedDouble = 0;
		boolean keepGoing = true;
		String errorMessage = "";
		
		do {
			try {
				keepGoing = true;
				verifiedString = JOptionPane.showInputDialog(null, message);
				
				for (int i = 0; i < verifiedString.length(); i++) {
					if (!Character.isDigit(verifiedString.charAt(i))) {
						errorMessage = "ERROR: debes introducir números";
						keepGoing = false;
						i = verifiedString.length();
					}
				}
			} catch (NullPointerException e) {
				errorMessage = "ERROR: no puedes cerrar esta ventana";
				keepGoing = false;
			} catch (Exception e) {
				errorMessage = "ERROR: ha surjido una excepción";
				keepGoing = false;
			}
			
			if (!keepGoing) {
				JOptionPane.showMessageDialog(null, errorMessage);
			} else {
				verifiedDouble = Double.parseDouble(verifiedString);
			}
		} while (!keepGoing);
		
		return verifiedDouble;
	}
	public static LocalDate paneErrorManagementLocalDate(String message) {
		String regex = "\\d{4}-\\d{2}-\\d{2}";
		String date;
		boolean keepGoing = false;
		
		do {
			date = paneErrorManagementString(message);
			
			if (date.matches(regex) && isValidDate(date)) {
				keepGoing = true;
			}
		} while (!keepGoing);
		
		return LocalDate.parse(date);
	}
	public static boolean isValidDate(String date) {
		String dateArray[] = date.split("-");
		
		if (Integer.parseInt(dateArray[0]) > 0 && Integer.parseInt(dateArray[0]) <= LocalDate.now().getYear()) {
			if (Integer.parseInt(dateArray[1]) > 0 && Integer.parseInt(dateArray[1]) <= 12) {
				if (Integer.parseInt(dateArray[2]) > 0 && Integer.parseInt(dateArray[2]) <= 31) {
					return true;
				}
			}
		}
			
		return false;
	}

	public static int[] paneReadArrayOfInt(String message, char divider) {
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
			readString = JOptionPane.showInputDialog(null, message);
			
			for (int i = 1; i < readString.length(); i++) {
				if (readString.charAt(0) == divider || readString.charAt(readString.length() - 1) == divider) {
					keepGoing = false;
					i = readString.length();
					errorMessage = "ERROR: no puedes introducir el separador al inicio ni al final";
				}
				if (readString.charAt(i - 1) == divider && readString.charAt(i) == divider) {
					keepGoing = false;
					i = readString.length();
					errorMessage = "ERROR: no puedes introducir 2 o más separadores juntos";
				}
				if (!Character.isDigit(readString.charAt(i)) && readString.charAt(i) != divider) {
					keepGoing = false;
					i = readString.length();
					errorMessage = "ERROR: has introducido un formato incorrecto";
				}
			}
			
			if (!keepGoing) {
				JOptionPane.showMessageDialog(null, errorMessage);
			}
			
		} while (!keepGoing);
		
		String stringArray[] = readString.split(Character.toString(divider));
		int intArray[] = new int[stringArray.length];
		
		for (int j = 0; j < stringArray.length; j++) {
			intArray[j] = Integer.parseInt(stringArray[j]);
		}
		
		return intArray;
	}
	public static void printPaneArrayOfInt(int array[]) {
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
		
		JOptionPane.showMessageDialog(null, sb);
	}
	public static int[][] paneReadMatrixOfInt(String message, char divider, int rows, int columns) {
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
			readString = JOptionPane.showInputDialog(null, message);
			
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
				String string_array[] = readString.split(Character.toString(divider));
				if (string_array.length == (rows * columns)) {
					
					int counter = 0;
					
					for (int j = 0; j < rows; j++) {
						for (int x = 0; x < columns; x++) {
							intMatrix[j][x] = Integer.parseInt(string_array[counter]);
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
				JOptionPane.showMessageDialog(null, errorMessage);
			}
		} while (!keepGoing);
		
		return intMatrix;
	}
	public static void printPaneMatrixOfInt(int matrix[][]) {
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
		
		JOptionPane.showMessageDialog(null, sb);
	}
	public static void printPaneMatrixOfString(String matrix[][]) {
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
		
		JOptionPane.showMessageDialog(null, sb);
	}
	public static void printPaneFinishProgram() {
		/*
		 * MÉTODO QUE INDICA AL USUARIO QUE EL
		 * PROGRAMA HA FINALIZADO.
		 */
		JOptionPane.showMessageDialog(null, "PROGRAMA FINALIZADO");
	}
	
}
