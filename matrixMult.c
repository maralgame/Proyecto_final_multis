//This program implements the matrix multiplication algorithm with sequential C programming
#include <stdio.h>
#include <stdlib.h>
#include "cheader.h"
//Dimensions of matrix
#define MAT_X 1000
#define MAT_Y 1000
#define MAT_Z 1000
//Algorithm implementation function
void MtxMult(int **mtx_a, int **mtx_b, int **mtx_c, int n, int m, int p) {
  int i, j, k;
  for (i = 0; i < n; i++) {
    for (j = 0; j < p; j++) {
      for (k = 0; k < m; k++) {
        mtx_c[i][j] += mtx_a[i][k] * mtx_b[k][j];
      }
    }
  }
}
//Main program
int main(int argc, char const *argv[]) {
  int i, **mtx_a, **mtx_b, **mtx_c;
  double ms;
  srand(time(NULL));
  //Allocation of memory for matrices
  mtx_a = (int **)malloc(MAT_X * sizeof(int*));
  mtx_b = (int **)malloc(MAT_Y * sizeof(int*));
  mtx_c = (int **)malloc(MAT_X * sizeof(int*));
  for(int i = 0; i < MAT_X; i++)
    mtx_a[i] = (int *)malloc(MAT_Y * sizeof(int));
  for(int i = 0; i < MAT_Y; i++)
    mtx_b[i] = (int *)malloc(MAT_Z * sizeof(int));
  for(int i = 0; i < MAT_X; i++)
    mtx_c[i] = (int *)malloc(MAT_Z * sizeof(int));
  //Filling matrices
  fill_matrix(mtx_a, MAT_X, MAT_Y);
  fill_matrix(mtx_b, MAT_Y, MAT_Z);
  //Fill result matrix with zeroes
  fill_matrix_zero(mtx_c, MAT_X, MAT_Z);
  display_matrix("A", mtx_a);
  display_matrix("B", mtx_b);
  //Indicator of process start
  printf("Calculating..\n");
  ms = 0;
  for (i = 0; i < N; i++) {
  start_timer();
  MtxMult(mtx_a, mtx_b, mtx_c, MAT_X, MAT_Y, MAT_Z);
  ms += stop_timer();
  }
  //Result display
  display_matrix("C", mtx_c);
  printf("avg time = %.5lf ms\n", (ms / N));
  return 0;
}

