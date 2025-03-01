package d;

public class Str {
	
	public static String replaceCharFromString(String s, char old_char, char new_char) {
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
			if (s.toUpperCase().charAt(i) == old_char) {
				sb.append(new_char);
			} else {
				sb.append(s.charAt(i));
			}
		}
		
		String replaced_string = sb.toString();
		return replaced_string;
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
		
		String reversed_string = sb.toString();
		return reversed_string;
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
}
