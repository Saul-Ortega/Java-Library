package d;

import java.util.Random;
import java.util.Scanner;

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
	
}
