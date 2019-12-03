//This class implements a matrix multiplication algorithm sequentially
public class JavaSerial {
	//Dimensions of matrix
	private static final int MAT_X = 1000;
	private static final int MAT_Y = 1000;
	private static final int MAT_Z = 1000;

	//Main class
	public static void main(String[] args) {
		//Definition of variables
		long startTime, stopTime;
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
		//Definition of algorithm object
		MtxMult MtxMult = new MtxMult(mtxA, mtxB, mtxC,MAT_X, MAT_Y,MAT_Z);
		//Exec time counter
		acum = 0;
		//For loop. Executes algorithm 10 times.
		for (int i = 0; i < Utils.N; i++) {
			startTime = System.currentTimeMillis();
			//Actual matrix multiplication algorithm being run
			MtxMult.calculate();
			stopTime = System.currentTimeMillis();
			acum += (stopTime - startTime);
		}
	//Results display
	Utils.displayMatrix("C", mtxC);
	System.out.printf("avg time = %.5fms\n", (acum / (double)Utils.N));
	}
}

