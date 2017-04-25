#include <stdio.h>

int main()
{
  int arr[3][3] = { { 'A', 'B', 'C' } , { 1, 2, 3 } };

  printf("array [0][0] contains %c\n", arr[0][0]);
  printf("array [1][0] contains %d\n", arr[1][0]);

  return 0;
}
