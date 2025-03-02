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
}
