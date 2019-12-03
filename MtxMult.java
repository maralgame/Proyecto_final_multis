//This class implements the matrix multiplication algorithm
public class MtxMult {
	private int mtxA[][];
	private int mtxB[][];
	private int mtxC[][];
	private int x;
	private int y;
	private int z;
	//Constructor
	public MtxMult(int a[][], int b[][], int c[][], int x, int y, int z) {
		this.mtxA = a;
		this.mtxB = b;
		this.mtxC = c;
		this.x = x;
		this.y = y;
		this.z = z;
	}
//Actual algorithm implementation
	public void calculate() {
		int i, j, k, sum;
		for (i = 0; i < this.x; i++) {
			for (j = 0; j < this.z; j++) {
				for (k = 0; k < this.y; k++) {
				this.mtxC[i][j] += this.mtxA[i][k] * this.mtxB[k][j];
				}
			}
		}
	}
}

