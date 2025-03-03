package d;

public class Vector {
	public static boolean containsIntArray(int array[], int n) {
		/*
		 * MÉTODO QUE RECIBE UN ARRAY DE TIPO INT Y OTRO DATO
		 * DE TIPO INT, USA UN BUCLE FOR PARA RECORRER EL ARRAY
		 * Y SI EL NÚMERO SE ENCUENTRA DENTRO DEL MISMO, RETORNA
		 * TRUE, DE OTRA MANERA, RETORNARÁ FALSE.
		 */
		for (int i = 0; i < array.length; i++) {
			if (array[i] == n) {
				return true;
			}
		}
		
	return false;
	}
	public static int returnPositionOfNumberIntArray(int array[], int n) {
		/*
		 * MÉTODO QUE RECIBE UN ARRAY DE TIPO INT Y OTRO DATO
		 * DE TIPO INT, USA UN BUCLE FOR PARA RECORRER EL ARRAY
		 * Y SI EL NÚMERO SE ENCUENTRA EN EL MISMO, RETORNA LA
		 * POSICIÓN, DE OTRA MANERA, RETORNARÁ -1.
		 */
		for (int i = 0; i < array.length; i++) {
			if (array[i] == n) {
				return i;
			}
		}
		
		return -1;
	}
	public static int returnNumberOfTimesIntArray(int array[], int n) {
		/*
		 * MÉTODO QUE RECIBE UN ARRAY DE TIPO INT Y OTRO DATO
		 * DE TIPO INT, USA UN BUCLE FOR PARA RECORRER EL ARRAY
		 * Y SI EL NÚMERO SE ENCUENTRA EN EL MISMO, AÑADE 1
		 * AL CONTADOR Y LO RETORNA.
		 */
		int counter = 0;
		
		for (int i = 0; i < array.length; i++) {
			if (array[i] == n) {
				counter++;
			}
		}
		
		return counter;
	}
	public static int[] returnIntArrayReplacingNumber(int array[], int replaced_number, int number_to_replace) {
		/*
		 * MÉTODO QUE RECIBE UN ARRAY DE TIPO INT Y OTROS 2
		 * DATOS DE TIPO INT QUE SON EL NÚMERO A REEMPLAZAR
		 * Y EL NÚMERO POR EL QUE SE VA A REEMPLAZAR.
		 * USA UN BUCLE FOR PARA RECORRER EL ARRAY Y
		 * REEMPLAZA EL NÚMERO Y DEVUELVE EL ARRAY.
		 */
		for (int i = 0; i < array.length; i++) {
			if (array[i] == replaced_number) {
				array[i] = number_to_replace;
			}
		}
		
		return array;
	}
	public static int[] returnConcatOfTwoArrays(int array1[], int array2[]) {
		/*
		 * MÉTODO QUE RECIBE 2 ARRAYS DE TIPO INT.
		 * USA 2 BUCLES FOR PARA CONCATENAR LOS 2 ARRAYS DE TIPO INT.
		 */
		int array3[] = new int[array1.length + array2.length];
		int counter = 0;
		
		for (int i = 0; i < array1.length; i++) {
			array3[counter] = array1[i];
			counter++;
		}
		for (int j = 0; j < array2.length; j++) {
			array3[counter] = array2[j];
			counter++;
		}
		
		return array3;
	}
	public static int[] returnConcatOfTwoArraysInPosition(int array1[], int array2[], int pos) {
		/*
		 * MÉTODO QUE RECIBE 2 ARRAYS DE TIPO INT Y OTRO DATO DE TIPO
		 * INT QUE REPRESENTA LA POSICIÓN.
		 * USA 2 BUCLES FOR PARA CONCATENAR LOS 2 ARRAYS DE TIPO INT
		 * EN LA POSICIÓN INDICADA Y RETORNA UN 3º ARRAY.
		 */
		int array3[] = new int[array1.length + array2.length];
		int counter = 0;
		
		for (int i = 0; i < array1.length; i++) {
			if (i == pos) {
				for (int j = 0; j < array2.length; j++) {
					array3[counter] = array2[j];
					counter++;
				}
			}
			array3[counter] = array1[i];
			counter++;
		}
		
		return array3;
	}
	public static int[] extractIntArray(int array[], int initial_pos, int final_pos) {
		/*
		 * MÉTODO QUE RECIBE UN ARRAY DE TIPO INT Y OTROS 2 DATOS
		 * DE TIPO INT QUE REPRESENTAN LA POSICIÓN INICIAL Y LA
		 * POSICIÓN FINAL.
		 * SE DECLARA UN NUEVO ARRAY DE TIPO INT Y SE USA UN BUCLE
		 * FOR Y SI LA VARIABLE "I" SE ENCUENTRA FUERA DE LA POSICIÓN
		 * INICIAL Y FINAL, INTRODUCE DATOS EN EL NUEVO ARRAY PARA RETORNARLO.
		 */
		int return_array[] = new int[array.length - (final_pos - initial_pos) - 1];
		int counter = 0;
		
		for (int i = 0; i < array.length; i++) {
			if (i < initial_pos || i > final_pos) {
				return_array[counter] = array[i];
				counter++;
			}
		}
		
		return return_array;
	}
	public static int[] minimumSelectionSort(int array[]) {
		/*
		 * MÉTODO QUE RECIBE UN ARRAY DE TIPO INT POR
		 * PARÁMETRO.
		 * USA UN BUCLE FOR E INICIALIZA LA VARIABLE "I"
		 * A OTRA VARIABLE LLAMADA "START_POS" PARA QUE NO
		 * RECORRA EL ARRAY ENTERO SINO EL RESTO Y RETORNA
		 * EL ARRAY ORDENADO.
		 */
		int min_value;
		int pos = 0;
		int start_pos = 0;
		int counter;
		int replaced_value;
		
		do {
			counter = 0;
			min_value = Integer.MAX_VALUE;
			for (int i = start_pos; i < array.length; i++) {
				if (min_value > array[i]) {
					min_value = array[i];
					pos = i;
					counter++;
				}
			}
			if (counter != 0) {
				replaced_value = array[start_pos];
				array[start_pos] = min_value;
				array[pos] = replaced_value;
				start_pos++;
			}
		} while (counter != 0);
		
		return array;
	}
	public static int[] bubbleSort(int array[]) {
		/*
		 * MÉTODO QUE RECIBE UN ARRAY DE TIPO INT POR
		 * PARÁMETRO.
		 * USA UNA VARIABLE DE TIPO INT "COUNTER" PARA SABER SI
		 * HAN HABIDO CAMBIOS EN EL ARRAY, SI NO ES ASÍ, PARA EL BUCLE
		 * Y RETORNA EL ARRAY.
		 */
		int counter;
		
		do  {
			counter = 0;
			for (int i = 1; i < array.length; i++) {
				if (array[i - 1] > array[i]) {
					int number_to_replace = array[i - 1];
					array[i - 1] = array[i];
					array[i] = number_to_replace;
					counter++;
				}
			}			
		} while (counter != 0);
	
		return array;
	}
	public static int[] returnNHighestNumbersInArray(int array[], int n) {
		/*
		 * MÉTODO QUE RECIBE UN ARRAY DE TIPO INT Y OTRO DATO DE TIPO
		 * INT QUE REPRESENTA LA CANTIDAD DE NÚMEROS QUE SE QUIEREN
		 * RECIBIR DEL ARRAY.
		 * CREA UN NUEVO ARRAY Y LE INTRODUCE LA CANTIDAD DE "N" DATOS
		 * QUE SEAN LOS MAYORES DEL ARRAY.
		 */
		int new_array[] = new int[n];
		int counter = 0;
		
		for (int i = array.length - n; i < array.length; i++) {
			new_array[counter] = array[i];
			counter++;
		}
		
		return new_array;
	}
	public static boolean isSortedArrayEqual(int array1[], int array2[]) {
		/*
		 * MÉTODO QUE RECIBE 2 ARRAYS DE TIPO INT POR
		 * PARÁMETROS.
		 * COMPARA QUE LOS 2 ARRAYS TENGAN EL MISMO TAMAÑO,
		 * SI NO, RETORNA FALSE, EN CASO AFIRMATIVO, LOS
		 * ORDENA Y COMPARA ELEMENTO POR ELEMENTO.
		 */
		if (array1.length != array2.length) {
			return false;
		} else {
			array1 = minimumSelectionSort(array1);
			array2 = minimumSelectionSort(array2);
			
			for (int i = 0; i < array1.length; i++) {
				if (array1[i] != array2[i]) {
					return false;
				}
			}
		}
		
		return true;
	}
	public static boolean isArrayEqual(int array1[], int array2[]) {
		/*
		 * MÉTODO QUE RECIBE 2 ARRAYS DE TIPO INT POR
		 * PARÁMETROS.
		 * COMPARA QUE TENGAN EL MISMO TAMAÑO Y QUE CADA
		 * ELEMENTO TENGA EL MISMO VALOR, EN CASO CONTRARIO
		 * RETORNARÁ FALSO.
		 */
		if (array1.length != array2.length) {
			return false;
		} else {
			for (int i = 0; i < array1.length; i++) {
				if (array1[i] != array2[i]) {
					return false;
				}
			}
		}
		
		return true;
	}
	public static int[] reverseArray(int array[]) {
		/*
		 * MÉTODO QUE RECIBE UN ARRAY DE TIPO INT
		 * POR PARÁMETRO.
		 * DIVIDE EL TAMAÑO DEL ARRAY ENTRE 2 PARA SABER
		 * EL NÚMERO DE REEMPLAZOS QUE TIENE QUE REALIZAR
		 * Y VA REEMPLAZANDO EL ARRAY HASTA QUE FINALICE.
		 */
		int array_length = array.length;
		double number_of_replacements = array_length / 2;
		int replaced_number;
		int position_of_replaced = 0;

		if (number_of_replacements % 2 != 0) {
			number_of_replacements -= 0.5;
		}

		for (int i = array_length - 1; i > 0; i--) {
			if (position_of_replaced < number_of_replacements) {
				replaced_number = array[position_of_replaced];
				array[position_of_replaced] = array[i];
				array[i] = replaced_number;

				position_of_replaced++;
			}
		}

		return array;
	}
	public static int[] sumOfTwoArrays(int array1[], int array2[]) {
		/*
		 * MÉTODO QUE RECIBE 2 ARRAYS DE TIPO INT
		 * POR PARÁMETROS.
		 * DECLARA UN 3 ARRAY Y CON UN BUCLE FOR,
		 * VA SUMANDO LOS VALORES DEL 1º Y EL 2º
		 * ARRAY EN EL 3º ARRAY.
		 */
		int array3[] = new int[array1.length];
		
		for (int i = 0; i < array1.length; i++) {
			array3[i] = array1[i] + array2[i];
		}
		
		return array3;
	}
	public static int returnMostRepeatedNumberInArray(int array[]) {
		/*
		 * MÉTODO QUE RECIBE UN ARRAY DE TIPO INT
		 * POR PARÁMETRO.
		 * SE DECLARA UN NUEVO ARRAY QUE ALMACENARÁ
		 * LAS VECES QUE SE REPITEN CADA UNO DE LOS
		 * NÚMEROS. LUEGO SE RECORRE ESTE NUEVO ARRAY
		 * Y SE RETORNA EL NÚMERO QUE MÁS VECES APARECE.
		 */
		int new_array[] = new int[10];
		int most_repeated_times = 0;
		int most_repeated_number = 0;
		
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < new_array.length; j++) {
				if (array[i] == j + 1) {
					new_array[j] += 1;
				}
			}
		}
		
		for (int x = 0; x < new_array.length; x++) {
			if (new_array[x] > most_repeated_times) {
				most_repeated_times = new_array[x];
				most_repeated_number = x + 1;
			}
		}
		
		return most_repeated_number;
	}
	
}
