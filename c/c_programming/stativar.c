#include <stdio.h>

static int num = 100;

int main()
{
  extern int num;
  printf("Global value: %d\n", num);

  return 0;
}
