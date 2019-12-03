//This class implements the matrix multiplication algorithm with ForkJoin parallel compatibility
import java.util.concurrent.ForkJoinPool;

public class JavaForkJoin {
	//Dimensions of matrix
	private static final int MAT_X = 1000;
	private static final int MAT_Y = 1000;
	private static final int MAT_Z = 1000;
	private static final int MAXTHREADS = Runtime.getRuntime().availableProcessors();

	public static void main(String[] args) {
		//Definition of variables
		long startTime, stopTime;
		ForkJoinPool pool;
		double acum = 0;
		//Definition of matrix size
		int mtxA[][] = new int[MAT_X][MAT_Y];
		int mtxB[][] = new int[MAT_Y][MAT_Z];
		int mtxC[][] = new int[MAT_X][MAT_Z];
		//Filling Matrix with numbers in a range defined in Utils library
		Utils.fillMatrix(mtxA);
		Utils.fillMatrix(mtxB);
		//Fill result matrix with zero
		Utils.fillMatrixZero(mtxC);
		Utils.displayMatrix("A", mtxA);
		Utils.displayMatrix("B", mtxB);
		acum = 0;

		for (int j = 1; j <= Utils.N; j++) {
			startTime = System.currentTimeMillis();
			//Use of ForkJoin library to implement parallelism
			pool = new ForkJoinPool(MAXTHREADS);
			pool.invoke(new MtxMultFJ(mtxA, mtxB, mtxC, MAT_X, MAT_Y, MAT_Z, 0,MAT_X));
			stopTime = System.currentTimeMillis();
			acum += (stopTime - startTime);
		}
		//Results display
		Utils.displayMatrix("C", mtxC);
		System.out.printf("avg time = %.5fms\n", (acum / (double)Utils.N));
	}
}

