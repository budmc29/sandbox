#include <stdio.h>

int main()
{
  enum colours
  { RED=1, YELLOW, GREEN, BROWN, BLUE, PINK, BLACK };
  int total;

  printf("I potted a red worth %d\n", RED);
  printf("I potted a black worth %d\n", BLACK);

  total = RED + BLACK;

  printf("Altogether I scored %d\n", total);

  return 0;
}
