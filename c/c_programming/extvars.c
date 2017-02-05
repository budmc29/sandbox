#include <stdio.h>

int num;

int main()
{
  extern int num;
  num=5;
  printf("Global variable alue is %d\n", num);

  return 0;
}
