//This class presents a set of auxiliary functions to manage arrays and matrices
import java.util.Random;

public class Utils {
	private static final int DISPLAY = 100;
	private static final int MAX_VALUE = 10_000;
	private static final Random r = new Random();

	public static final int MAXTHREADS = Runtime.getRuntime().availableProcessors();
	public static final int N = 10;

	public static void randomArray(int array[]) {
		for (int i = 0; i < array.length; i++) {
			array[i] = r.nextInt(MAX_VALUE) + 1;
		}
	}

	public static void fillArray(int array[]) {
		for (int i = 0; i < array.length; i++) {
			array[i] = (i % MAX_VALUE) + 1;
		}
	}

	public static void displayArray(String text, int array[]) {
		System.out.printf("%s = [%4d", text, array[0]);
		for (int i = 1; i < DISPLAY; i++) {
			System.out.printf(",%4d", array[i]);
		}
		System.out.printf(", ..., ]\n");
	}

	public static void fillMatrix(int matrix[][]) {
		for (int i = 0; i < matrix.length; i++)
			for (int j = 0; j < matrix[i].length; j++)
				matrix[i][j] = (j % MAX_VALUE) + 1;
	}

	public static void fillMatrixZero(int matrix[][]) {
		for (int i = 0; i < matrix.length; i++)
			for (int j = 0; j < matrix[i].length; j++)
				matrix[i][j] = 0;
	}

	public static void displayMatrix(String text, int[][] matrix) {
		System.out.printf("%s = [", text);
		for (int i = 0; i < DISPLAY; i++) {
			System.out.printf("[%10d", matrix[i][0]);
			for (int j = 1; j < DISPLAY; j++) {
				System.out.printf(",%10d", matrix[i][j]);
			}
			System.out.printf(", ...],");
		}
		System.out.printf(", ..., ]\n");
		}
}

