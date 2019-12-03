//This program implements the matrix multiplication algorithm with sequential C++ programming
#include <iostream>
#include "cppheader.h"
using namespace std;
//Dimensions of matrix
#define MAT_X 1000
#define MAT_Y 1000
#define MAT_Z 1000
//Algorithm implementation class
class matrixMultCPP {
  private:
  int **mtx_a;
  int **mtx_b;
  int **mtx_c;
  int x;
  int y;
  int z;
  public:
  matrixMultCPP(int **m1, int **m2, int **m3, int x, int y, int z) :
  mtx_a(m1), mtx_b(m2),  mtx_c(m3), x(x), y(y), z(z) {}
  //Actual algorithm implementation method
  void multiply() {
    int i, j, k, sum;
    for (i = 0; i < x; i++) {
      for (j = 0; j < z; j++) {
        for (k = 0; k < y; k++) {
          mtx_c[i][j] += mtx_a[i][k] * mtx_b[k][j];
        }
      }
    }
  }
};
//Main class
int main(int argc, char* argv[]) {
  Timer t;
  double ms;
  int i;
  //Allocation of memory for matrices
  int** mtx_a = new int*[MAT_X];
  int** mtx_b = new int*[MAT_Y];
  int** mtx_c = new int*[MAT_X];
  for (i = 0; i < MAT_X; ++i)
    mtx_a[i] = new int[MAT_Y];
  for (i = 0; i < MAT_Y; ++i)
    mtx_b[i] = new int[MAT_Z];
  for (i = 0; i < MAT_X; ++i)
    mtx_c[i] = new int[MAT_Z];
  //Filling matrices
  fill_matrix(mtx_a, MAT_X, MAT_Y);
  fill_matrix(mtx_b, MAT_Y, MAT_Z);
  //Fill result matrix with zeroes
  fill_matrix_zero(mtx_c, MAT_X, MAT_Z);
  //Matrix multiplier object
  matrixMultCPP matrixMultObj = matrixMultCPP(mtx_a, mtx_b, mtx_c, MAT_X, MAT_Y, MAT_Z);
  //Indicator of process start
  cout << "Calculating...\n";
  ms = 0;
  for (int i = 0; i < N; i++) {
    t.start();
    matrixMultObj.multiply();
    ms += t.stop();
  }
  //Result display
  display_matrix("C:", mtx_c);
  cout << "avg time = " << (ms / N) << " ms\n";
  delete [] mtx_a;
  return 0;
}
