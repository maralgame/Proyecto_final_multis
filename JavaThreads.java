//This class implements the matrix multiplication algorithm with JavaThreads parallel compatibility
public class JavaThreads {
	//Dimensions of matrix
	private static final int MAT_X = 1000;
	private static final int MAT_Y = 1000;
	private static final int MAT_Z = 1000;
	private static final int MAXTHREADS = Runtime.getRuntime().availableProcessors();

	public static void main(String[] args) {
		//Definition of variables
		long startTime, stopTime;
		MtxMultTh threads[];
		int block;
		double acum = 0;
		//Definition of matrix size
		int mtxA[][] = new int[MAT_X][MAT_Y];
		int mtxB[][] = new int[MAT_Y][MAT_Z];
		int mtxC[][] = new int[MAT_X][MAT_Z];
		Utils.fillMatrix(mtxA);
		Utils.fillMatrix(mtxB);
		//Fill result matrix with zero
		Utils.fillMatrixZero(mtxC);
		Utils.displayMatrix("A", mtxA);
		Utils.displayMatrix("B", mtxB);
		block = MAT_X / MAXTHREADS;
		threads = new MtxMultTh[MAXTHREADS];
		acum = 0;

		for (int j = 1; j <= Utils.N; j++) {
			for (int i = 0; i < threads.length; i++) {
				if (i != threads.length - 1) {
				threads[i] = new MtxMultTh(mtxA, mtxB, mtxC, MAT_X, MAT_Y, MAT_Z, (i * block),((i + 1) * block));
				} else {
				threads[i] = new MtxMultTh(mtxA, mtxB, mtxC, MAT_X, MAT_Y,
				MAT_Z, (i * block),
				MAT_X);
				}
			}

			startTime = System.currentTimeMillis();
			//Thread implementation
			for (int i = 0; i < threads.length; i++) {
				threads[i].start();
			}
			for (int i = 0; i < threads.length; i++) {
				try {
					threads[i].join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			stopTime = System.currentTimeMillis();
			acum += (stopTime - startTime);
		}
		//Results display
		Utils.displayMatrix("C", mtxC);
		System.out.printf("avg time = %.5fms\n", (acum / (double)Utils.N));
	}
}

