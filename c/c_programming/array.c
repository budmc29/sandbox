#include <stdio.h>

int main()
{
  int arr[3] = { 10, 2, 8 };

  arr[1] = 9;
  arr[3] = 7;

  printf("Element 0: %d\n", arr[0] );
  printf("Element 1: %d\n", arr[1] );
  printf("Element 2: %d\n", arr[2] );
  printf("Element 3: %d\n", arr[3] );
}
