//This is a header file that includes several auxiliary functions for C programming
#ifndef TIMER_H_
#define TIMER_H_
#include <stdlib.h>
#include <time.h>
#include <sys/time.h>
#include <sys/types.h>
#define N 10
#define DISPLAY 10
#define MAX_VALUE 10000

struct timeval startTime, stopTime;
int started = 0;
void start_timer() {
  started = 1;
  gettimeofday(&startTime, NULL);
}

double stop_timer() {
  long seconds, useconds;
  double duration = -1;
  if (started) {
    gettimeofday(&stopTime, NULL);
    seconds = stopTime.tv_sec - startTime.tv_sec;
    useconds = stopTime.tv_usec - startTime.tv_usec;
    duration = (seconds * 1000.0) + (useconds / 1000.0);
    started = 0;
  }
  return duration;
}

void random_array(int *array, int size) {
  int i;
  for (i = 0; i < size; i++) {
    array[i] = (rand() % 100) + 1;
  }
}
void fill_array(int *array, int size) {
  int i;
  for (i = 0; i < size; i++) {
    array[i] = (i % MAX_VALUE) + 1;
  }
}
void display_array(char *text, int *array) {
  int i;
  printf("%s = [%4i", text, array[0]);
  for (i = 1; i < DISPLAY; i++) {
    printf(",%4i", array[i]);
  }
  printf(", ... ,]\n");
}

void random_matrix(int **mat, int size) {
  for (int i = 0; i < size; i++) {
    for (int j = 0; j < size; j++) {
      mat[i][j] = (rand() % 100) + 1;
    }
  }
}

void fill_matrix(int **mat, int m, int n) {
  for (int i = 0; i < m; i++)
    fill_array(mat[i], n);
}
void fill_matrix_zero(int **mat, int m, int n) {
  for (int i = 0; i < m; i++)
    for (int j = 0; j < n; j++)
      mat[i][j] = 0;
}
void display_matrix(char *text, int **mat) {
  printf("%s = [", text);
  for (int i = 0; i < DISPLAY; i++) {
    printf("[%10i", mat[i][0]);
    for (int j = 1; j < DISPLAY; j++) {
      printf(",%10i", mat[i][j]);
    }
    printf(", ...],");
  }
  printf(" ...]\n");
}
#endif /* TIMER_H_ */

