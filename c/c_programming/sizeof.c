#include <stdio.h>

int main()
{
  printf("short int: %ld bytes\t", sizeof(short int));
  printf("long int: %ld bytes\n", sizeof(long int));
  printf("unsigned long int: %ld bytes\n", sizeof(unsigned long int));
  printf("char: %ld bytes\t", sizeof(char));
  printf("float: %ld bytes\t", sizeof(float));
  printf("double: %ld bytes\t\n", sizeof(double));

  return 0;
}
