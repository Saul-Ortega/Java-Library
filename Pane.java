package d;

import java.util.InputMismatchException;
import java.util.Scanner;

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
		String verified_string = "";
		boolean keep_going = true;
		int length_limit = 8;
		String error_message;
		
		do {
			try {
				keep_going = true;
				error_message = "ERROR: has introducido un formato incorrecto";
				verified_string = JOptionPane.showInputDialog(null, message);
				
				if (verified_string.length() > length_limit) {
					error_message = "ERROR: se ha superado el límite de " + length_limit + " caracteres";
					keep_going = false;
				} else if (verified_string.length() == 0) {
					error_message = "ERROR: no se ha introducido ningún dato";
					keep_going = false;
				} else {
					for (int i = 0; i < verified_string.length(); i++) {
						if (!Character.isLetter(verified_string.charAt(i)) && !Character.isSpaceChar(' ')) {
							i = verified_string.length();
							keep_going = false;
						}
					}					
				}
			} catch (Exception e) {
				error_message = "ERROR: ha surjido una excepción";
				keep_going = false;
			}
			
			if (!keep_going) {
				JOptionPane.showMessageDialog(null, error_message);
			}
			
		} while (!keep_going);
		
		return verified_string;
	}
	public static int paneErrorManagementInt(String message) {
		/*
		 * MÉTODO QUE RECIBE UN OBJETO DE TIPO SCANNER PARA LEER
		 * POR PANEL Y OTRO DE TIPO STRING QUE REPRESENTA UN
		 * MENSAJE.
		 * SE CONTROLA QUE EL USUARIO PONGA UN NÚMERO ENTERO.
		 */
		String verified_string = "";
		int verified_int = 0;
		boolean keep_going = true;
		String error_message = "";
		
		do {
			try {
				keep_going = true;
				verified_string = JOptionPane.showInputDialog(null, message);
				
				for (int i = 0; i < verified_string.length(); i++) {
					if (!Character.isDigit(verified_string.charAt(i))) {
						error_message = "ERROR: debes introducir números";
						keep_going = false;
						i = verified_string.length();
					}
				}
			} catch (NullPointerException e) {
				error_message = "ERROR: no puedes cerrar esta ventana";
				keep_going = false;
			} catch (Exception e) {
				error_message = "ERROR: ha surjido una excepción";
				keep_going = false;
			}
			
			if (!keep_going) {
				JOptionPane.showMessageDialog(null, error_message);
			} else {
				verified_int = Integer.parseInt(verified_string);
			}
		} while (!keep_going);
		
		return verified_int;
	}
	public static double consoleErrorManagementDouble(String message) {
		/*
		 * MÉTODO QUE RECIBE UN OBJETO DE TIPO SCANNER PARA LEER
		 * POR JOPTIONPANE Y OTRO DE TIPO STRING QUE REPRESENTA UN
		 * MENSAJE.
		 * SE CONTROLA QUE EL USUARIO PONGA UN NÚMERO CON COMA
		 * FLOTANTE.
		 */
		String verified_string = "";
		double verified_double = 0;
		boolean keep_going = true;
		String error_message = "";
		
		do {
			try {
				keep_going = true;
				verified_string = JOptionPane.showInputDialog(null, message);
				
				for (int i = 0; i < verified_string.length(); i++) {
					if (!Character.isDigit(verified_string.charAt(i))) {
						error_message = "ERROR: debes introducir números";
						keep_going = false;
						i = verified_string.length();
					}
				}
			} catch (NullPointerException e) {
				error_message = "ERROR: no puedes cerrar esta ventana";
				keep_going = false;
			} catch (Exception e) {
				error_message = "ERROR: ha surjido una excepción";
				keep_going = false;
			}
			
			if (!keep_going) {
				JOptionPane.showMessageDialog(null, error_message);
			} else {
				verified_double = Double.parseDouble(verified_string);
			}
		} while (!keep_going);
		
		return verified_double;
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
		String read_string;
		boolean keep_going = true;
		String error_message = "";
		
		do {
			keep_going = true;
			read_string = JOptionPane.showInputDialog(null, message);
			
			for (int i = 1; i < read_string.length(); i++) {
				if (read_string.charAt(0) == divider || read_string.charAt(read_string.length() - 1) == divider) {
					keep_going = false;
					i = read_string.length();
					error_message = "ERROR: no puedes introducir el separador al inicio ni al final";
				}
				if (read_string.charAt(i - 1) == divider && read_string.charAt(i) == divider) {
					keep_going = false;
					i = read_string.length();
					error_message = "ERROR: no puedes introducir 2 o más separadores juntos";
				}
				if (!Character.isDigit(read_string.charAt(i)) && read_string.charAt(i) != divider) {
					keep_going = false;
					i = read_string.length();
					error_message = "ERROR: has introducido un formato incorrecto";
				}
			}
			
			if (!keep_going) {
				JOptionPane.showMessageDialog(null, error_message);
			}
			
		} while (!keep_going);
		
		String string_array[] = read_string.split(Character.toString(divider));
		int int_array[] = new int[string_array.length];
		
		for (int j = 0; j < string_array.length; j++) {
			int_array[j] = Integer.parseInt(string_array[j]);
		}
		
		return int_array;
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
		String read_string;
		boolean keep_going = true;
		String error_message = "";
		int int_matrix[][] = new int[rows][columns];
		
		do {
			keep_going = true;
			read_string = JOptionPane.showInputDialog(null, message);
			
			for (int i = 1; i < read_string.length(); i++) {
				if (read_string.charAt(0) == divider || read_string.charAt(read_string.length() - 1) == divider) {
					keep_going = false;
					i = read_string.length();
					error_message = "ERROR: no puedes introducir el separador al inicio ni al final";
				} else if (read_string.charAt(i - 1) == divider && read_string.charAt(i) == divider) {
					keep_going = false;
					i = read_string.length();
					error_message = "ERROR: no puedes introducir 2 o más separadores juntos";
				} else if (!Character.isDigit(read_string.charAt(i)) && read_string.charAt(i) != divider) {
					keep_going = false;
					i = read_string.length();
					error_message = "ERROR: has introducido un formato incorrecto";
				}
			}
			
			if (keep_going) {
				String string_array[] = read_string.split(Character.toString(divider));
				if (string_array.length == (rows * columns)) {
					
					int counter = 0;
					
					for (int j = 0; j < rows; j++) {
						for (int x = 0; x < columns; x++) {
							int_matrix[j][x] = Integer.parseInt(string_array[counter]);
							counter++;
						}
					}
					
					return int_matrix;
				} else {
					keep_going = false;
					error_message = "ERROR: no has introducido los datos correctamente";
				}
			}
			
			if (!keep_going) {
				JOptionPane.showMessageDialog(null, error_message);
			}
		} while (!keep_going);
		
		return int_matrix;
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
