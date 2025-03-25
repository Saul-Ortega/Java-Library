package d;

import java.util.Random;

public class Matrix {
	public static int[][] getRandomMatrixOfInt(int rows, int columns) {
		/*
		 * MÉTODO QUE RECIBE 2 INTS POR PARÁMETRO QUE
		 * REPRESENTAN LAS FILAS Y COLUMNAS DE LA MATRIZ.
		 * SE DECLARA LA MATRIZ CON EL TAMAÑO ESPECIFICADO,
		 * SE RELLENA CON NÚMEROS ALEATORIOS ENTRE 1 Y 10 Y
		 * CUANDO FINALIZA, RETORNA LA MATRIZ.
		 */
		Random r = new Random();
		int matrix[][] = new int[rows][columns];
		
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				matrix[i][j] = r.nextInt(10) + 1;
			}
		}
		
		return matrix;
	}
	public static int[][] sumOfTwoMatrixOfInt(int matrix1[][], int matrix2[][]) {
		/*
		 * MÉTODO QUE RECIBE 2 MATRICES DE TIPO INT
		 * POR PARÁMETRO.
		 * SE DECLARA UNA 3º MATRIZ DE TIPO INT, SE
		 * RELLENA CON LA SUMA DE LOS VALORES DE LAS 2
		 * MATRICES Y SE RETORNA.
		 */
		int matrix3[][] = new int[matrix1.length][matrix1[0].length];
		
		for (int i = 0; i < matrix3.length; i++) {
			for (int j = 0; j < matrix3[0].length; j++) {
				matrix3[i][j] = matrix1[i][j] + matrix2[i][j];
			}
		}
		
		return matrix3;
	}
	public static boolean isMatrixEqual(int matrix1[][], int matrix2[][]) {
		/*
		 * MÉTODO QUE RECIBE 2 MATRICES DE TIPO INT
		 * POR PARÁMETROS.
		 * COMPARA QUE LOS TAMAÑOS DE LAS FILAS Y LAS
		 * COLUMNAS SEAN IGUALES Y LUEGO, COMPARA VALOR
		 * POR VALOR Y SI SON IGUALES DEVUELVE TRUE.
		 */
		if (matrix1.length != matrix2.length || matrix1[0].length != matrix2[0].length) {
			return false;
		}
		for (int i = 0; i < matrix1.length; i++) {
			for (int j = 0; j < matrix1[0].length; j++) {
				if (matrix1[i][j] != matrix2[i][j]) {
					return false;
				}
			}
		}
		
		return true;
	}
	public static String[][] returnConcatOfTwoMatrix(String matrix1[][], String matrix2[][]) {
		/*
		 * MÉTODO QUE RECIBE 2 MATRICES DE TIPO STRING
		 * POR PARÁMETRO.
		 * SE DECLARA UNA NUEVA MATRIZ DE TIPO STRING QUE
		 * ALMACENARÁ LA CONCATENACIÓN DE AMBAS MATRICES
		 * Y LUEGO SE RETORNA.
		 */
		String new_matrix[][] = new String[matrix1.length][matrix1[0].length + matrix2[0].length];
		int counter_columns = 0;
		
		for (int i = 0; i < matrix1.length; i++) {
			for (int j = 0; j < matrix1[0].length; j++) {
				new_matrix[i][j] = matrix1[i][j];
			}
		}
		
		for (int x = 0; x < matrix2.length; x++) {
			counter_columns = matrix1[0].length;
			for (int y = 0; y < matrix2[0].length; y++) {
				new_matrix[x][counter_columns] = matrix2[x][y];
				counter_columns++;
			}
		}
		
		return new_matrix;
	}
	public static int[][] transposeMatrix(int matrix[][]) {
		/*
		 * MÉTODO QUE RECIBE UNA MATRIZ POR
		 * PARÁMETRO.
		 * DECLARA UNA NUEVA MATRIZ Y LE INTRODUCE
		 * LOS DATOS DE FORMA TRANSPUESTA.
		 */
		int new_matrix[][] = new int[matrix[0].length][matrix.length];
		
		for (int i = 0; i < new_matrix.length; i++) {
			for (int j = 0; j < new_matrix[0].length; j++) {
				new_matrix[i][j] = matrix[j][i];
			}
		}
		
		return new_matrix;
	}
	public static int getLongestColumnFromString(String s, char divider_rows, char divider_columns) {
		/*
		 * MÉTODO QUE RECIBE UN OBJETO DE TIPO STRING PARA QUE
		 * CONVERTIRLO EN UNA MATRIZ DE TIPO STRING Y 2 DATOS DE TIPO
		 * CHAR QUE REPRESENTAN LOS SEPARADORES DE COLUMNAS Y DE LAS FILAS.
		 * DECLARA 2 VARIABLES DE TIPO INT QUE REPRESENTAN UN CONTADOR DEL
		 * SEPARADOR Y LA VARIABLE DE COLUMNAS MÁXIMAS QUE SERÁ LA QUE SE
		 * RETORNARÁ.
		 */
		int max_columns = 0;
		int counter_divider = 1;
		
		for (int i = 0; i < s.length(); i++) {
			
			if (s.charAt(i) == divider_columns) {
				counter_divider++;
			}
			
			if (counter_divider > max_columns) {
				max_columns = counter_divider;
			}
			
			if (s.charAt(i) == divider_rows) {
				counter_divider = 1;
			}
			
		}
		
		return max_columns;
	}
	public static String[][] returnStringMatrixFromString(String s, char divider_rows, char divider_columns) {
		/*
		 * MÉTODO QUE RECIBE UN OBJETO DE TIPO STRING PARA QUE
		 * CONVERTIRLO EN UNA MATRIZ DE TIPO STRING Y 2 DATOS DE TIPO
		 * CHAR QUE REPRESENTAN LOS SEPARADORES DE COLUMNAS Y DE LAS FILAS.
		 * DECLARA UN ARRAY DE TIPO STRING PARA ALMACENAR LOS DATOS EN FILAS,
		 * LUEGO MEDIANTE OTRO MÉTODO, SE OBTIENE LAS COLUMNAS QUE SE NECESITARÁN
		 * PARA LA MATRIZ Y VA ALMACENANDO LOS DATOS EN LA MATRIZ PARA LUEGO,
		 * RETORNARLO
		 */
		String rows_array[] = s.split(Character.toString(divider_rows));
		
		int rows = rows_array.length;
		
		int columns = getLongestColumnFromString(s, divider_rows, divider_columns);
		
		
		String matrix[][] = new String[rows][columns];
		
		int counter;
		
		for (int i = 0; i < rows; i++) {
			counter = 0;
			String columns_array[] = rows_array[i].split(Character.toString(divider_columns));
			for (int j = 0; j < columns_array.length; j++) {
				matrix[i][j] = columns_array[counter];
				counter++;
			}
		}
		
		return matrix;
	}
	public static String[][] returnAverageOfTwoNumsFromStringMatrix(String matrix[][]) {
		/*
		 * MÉTODO QUE RECIBE UNA MATRIZ DE TIPO STRING POR
		 * PARÁMETROS.
		 * USA 2 BUCLES FOR, CONSIGUE LOS VALORES DE LA TEMPERATURA
		 * MÁXIMA Y MÍNIMA, LUEGO SACA LA MEDIA Y LO CASTEA A UN STRING.
		 * POSTERIORMENTE, LO RETORNA
		 */
		String new_matrix[][] = new String[matrix.length][matrix[0].length + 1];
		
		for (int i = 0; i < new_matrix.length; i++) {
			for (int j = 0; j < new_matrix[0].length; j++) {
				if (j == 3) {
					double first_temp = Double.parseDouble(matrix[i][1]);
					double second_temp = Double.parseDouble(matrix[i][2]);
					new_matrix[i][j] = Double.toString((first_temp + second_temp) / 2);
				} else {
					new_matrix[i][j] = matrix[i][j];					
				}
			}
		}
		
		return new_matrix;
	}
}
