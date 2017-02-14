#include <stdio.h>

enum colours { RED=1, YELLOW, GREEN, BROWN, BLUE, PINK, BLACK };

typedef enum colours COLOURS;

typedef unsigned short int USHRT;

int main()
{

  USHRT num = 16;
  COLOURS fingers = (COLOURS) BROWN + PINK;

  printf("values: %d %d\n", fingers, num);

}
