//This class implements the matrix multiplication algorithm with Fork-Join
import java.util.concurrent.RecursiveAction;
public class MtxMultFJ extends RecursiveAction {
	private static final long MIN = 84;
	private int matA[][];
	private int matB[][];
	private int matC[][];
	private int x;
	private int y;
	private int z;
	private int start;
	private int end;

	public MtxMultFJ(int a[][], int b[][], int c[][], int x, int y, int z, int start, int end) {
		this.matA = a;
		this.matB = b;
		this.matC = c;
		this.x = x;
		this.y = y;
		this.z = z;
		this.start = start;
		this.end = end;
	}

	protected void computeDirectly() {
		int i, j, k;
		for (i = this.start; i < this.end; i++) {
			for (j = 0; j < this.z; j++) {
				for (k = 0; k < this.y; k++) {
					this.matC[i][j] += this.matA[i][k] * this.matB[k][j];
				}
			}
		}
	}

	@Override
	protected void compute() {
		if ( (this.end - this.start) <= MtxMultFJ.MIN ) {
			computeDirectly();
		} else {
			int middle = (end + start) / 2;
			invokeAll(new MtxMultFJ(this.matA, this.matB, this.matC, this.x,this.y, this.z, this.start, middle),
			new MtxMultFJ(this.matA, this.matB, this.matC, this.x, this.y,this.z, middle,this.end));
		}
	}
}

