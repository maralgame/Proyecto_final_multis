//This class implements the matrix multiplication algorithm with Java Threads
public class MtxMultTh extends Thread {
	private int matA[][];
	private int matB[][];
	private int matC[][];
	private int n;
	private int m;
	private int p;
	private int start, end;

	public MtxMultTh(int a[][], int b[][], int c[][], int n, int m, int p, int start, int end) {
		this.matA = a;
		this.matB = b;
		this.matC = c;
		this.n = n;
		this.m = m;
		this.p = p;
		this.start = start;
		this.end = end;
	}
	public void run() {
		int i, j, k;
		for (i = this.start; i < this.end; i++) {
			for (j = 0; j < this.p; j++) {
				for (k = 0; k < this.m; k++) {
					this.matC[i][j] += this.matA[i][k] * this.matB[k][j];
				}
			}
		}
	}
}

