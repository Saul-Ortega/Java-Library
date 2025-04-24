package d;

public class Str {
	
	public static String replaceCharFromString(String s, char oldChar, char newChar) {
		/*
		 * MÉTODO QUE RECIBE UN PARÁMETRO DE TIPO STRING QUE ES
		 * LA PALABRA A REEMPLAZAR Y 2 VARIABLES DE TIPO CHAR
		 * QUE REPRESENTAN EL CARÁCTER QUE SE DESEA INTERCAMBIAR
		 * POR EL NUEVO.
		 * SE EVALÚA QUE EL CARÁCTER ACTUAL DEL STRING SEA IGUAL
		 * QUE EL CARÁCTER QUE SE DESEA REEMPLAZAR Y LUEGO MEDIANTE
		 * UN STRINGBUFFER SE VA AÑADIENDO CARÁCTER POR CARÁCTER.
		 */
		StringBuffer sb = new StringBuffer("");
		
		for (int i = 0; i < s.length(); i++) {
			if (s.toUpperCase().charAt(i) == oldChar) {
				sb.append(newChar);
			} else {
				sb.append(s.charAt(i));
			}
		}
		
		return sb.toString();
	}
	public static boolean isEqual(String s1, String s2) {
		/*
		 * MÉTODO QUE RECIBE 2 STRINGS POR PARÁMETROS
		 * Y COMPARA SI TIENEN EL MISMO TAMAÑO Y MISMOS
		 * CARACTERES INCLUSO SI UNO ESTÁ EN MAYÚSCULAS
		 * Y OTRO EN MINÚSCULAS.
		 */
		if (s1.length() != s2.length()) {
			return false;
		} else {
			for (int i = 0; i < s1.length(); i++) {
				if (s1.toUpperCase().charAt(i) != s2.toUpperCase().charAt(i)) {
					return false;
				}
			}
		}
		
		return true;
	}
	public static String reverseString(String s) {
		/*
		 * MÉTODO QUE RECIBE UN STRING POR PARÁMETRO
		 * Y LE DA LA VUELTA.
		 * MEDIANTE UN BUCLE FOR SE INICIALIZA LA VARIABLE
		 * I AL FINAL DEL TAMAÑO DEL STRING - 1 Y SE VA DECREMENTANDO
		 * HASTA QUE SEA IGUAL A 0.
		 */
		StringBuffer sb = new StringBuffer("");
		
		for (int i = s.length() - 1; i >= 0; i--) {
			sb.append(s.charAt(i));
		}
		
		return sb.toString();
	}
	public static boolean isAnagram(String s1, String s2) {
		/*
		 * MÉTODO QUE RECIBE POR PARÁMETROS 2 STRINGS,
		 * COMPARAN QUE TENGA EL MISMO TAMAÑO Y SE USA UN
		 * CONTADOR PARA IR CONTANDO LOS CARACTERES QUE SE
		 * REPITEN ENTRE LOS 2 STRINGS Y SI EL CONTADOR ES
		 * IGUAL QUE EL TAMAÑO DE UNO DE LOS STRINGS, RETORNA
		 * TRUE Y SI NO, FALSE.
		 */
		int counter = 0;
		
		if (s1.length() != s2.length()) {
			return false;
		} else {
			for (int i = 0; i < s1.length(); i++) {
				for (int j = 0; j < s2.length(); j++) {
					if (s1.charAt(i) == s2.charAt(j)) {
						counter++;
						j = s2.length();
					}
				}
			}
		}
		
		if (counter != s1.length()) {
			return false;
		} else {
			return true;
		}
	}
	public static String extractString(String s, int initialPos, int finalPos) {
		/*
		 * MÉTODO QUE RECIBE UN STRING QUE REPRESENTA LA CADENA
		 * Y 2 DATOS DE TIPO INT QUE REPRESENTAN LA POSICIÓN INICIAL
		 * Y FINAL.
		 * USA UN BUCLE FOR E INICIALIZA LA I AL VALOR DE LA POSICIÓN
		 * INCIAL Y FINALIZA EL BUCLE CUANDO LLEGA A LA POSICIÓN
		 * FINAL.
		 */
		StringBuffer sb = new StringBuffer("");
		
		for (int i = initialPos; i <= finalPos; i++) {
			sb.append(s.charAt(i));
		}
		
		return sb.toString();
	}
	public static String deleteString(String s, int initialPos, int finalPos) {
		/*
		 * MÉTODO QUE RECIBE UN STRING QUE REPRESENTA LA CADENA
		 * Y 2 DATOS DE TIPO INT QUE REPRESENTAN LA POSICIÓN INICIAL
		 * Y FINAL.
		 * USA UN BUCLE FOR E INICIALIZA LA VARIABLE "I" A 0 Y REPITE EL BUCLE
		 * HASTA LLEGAR AL TAMAÑO DEL STRING, EVALÚA QUE "I" SEA INFERIOR QUE
		 * LA POSICIÓN INICIAL O SUPERIOR A LA POSICIÓN FINAL.
		 */
		StringBuffer sb = new StringBuffer("");
		
		for (int i = 0; i < s.length(); i++) {
			if (i < initialPos || i > finalPos) {
				sb.append(s.charAt(i));
			}
		}
		
		return sb.toString();
	}
	public static String insertString(String s1, String s2, int initialPos) {
		/*
		 * MÉTODO QUE RECIBE 2 STRINGS POR PARÁMETROS QUE REPRESENTAN
		 * 2 CADENAS DE TEXTO Y UN DATO DE TIPO INT QUE REPRESENTA
		 * LA POSICIÓN INICIAL.
		 * USA UN BUCLE FOR E INICIALIZA LA VARIABLE "I" A O Y REPITE
		 * EL BUCLE HASTA QUE LLEGUE AL FINAL DEL TAMAÑO DEL 1º STRING,
		 * POSTERIORMENTE EVALÚA QUE LA VARIABLE "I" SEA IGUAL A LA POSICIÓN
		 * INICIAL PARA AÑADIR EL 2º STRING Y SIGUE AÑADIENDO LOS CARACTERES
		 * DEL 1º STRING.
		 */
		StringBuffer sb = new StringBuffer("");
		
		for (int i = 0; i < s1.length(); i++) {
			if (i == initialPos) {
				sb.append(s2);
			}
			sb.append(s1.charAt(i));
		}
		
		return sb.toString();
	}
	public static int countWords(String s) {
		/*
		 * MÉTODO QUE RECIBE POR PARÁMETRO UN OBJETO DE TIPO STRING.
		 * CONVIERTE EL STRING EN UN ARRAY DEL MISMO TIPO Y RETORNA
		 * EL TAMAÑO DE DICHO ARRAY.
		 */
		String sArray[] = s.split(" ");
		
		return sArray.length;
	}
	public static String longestWord(String s) {
		/*
		 * MÉTODO QUE RECIBE POR PARÁMETRO UN OBJETO DE TIPO STRING.
		 * CONVIERTE EL STRING EN UN ARRAY DEL MISMO TIPO, LUEGO
		 * USA UN BUCLE FOR Y EVALÚA LA PALABRA DE MAYOR TAMAÑO Y
		 * POSTERIORMENTE SE LO ASIGNA A LA VARIABLE "LONGEST_WORD".
		 */
		String sArray[] = s.split(" ");
		String longestWord = "";
		
		for (int i = 0; i < sArray.length; i++) {
			if (sArray[i].length() > longestWord.length()) {
				longestWord = sArray[i];
			}
		}
		
		return longestWord;
	}
}
