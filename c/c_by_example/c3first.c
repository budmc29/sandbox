/* Filename: c3first.c */

#include <stdio.h>
main()
{
  int i, j;
  char c;
  float x;

  i = 4;
  j = i + 7;
  c = 'A';

  x = 9.087;

  x = x * 4.5;

  printf("%d %d %c %f", i, j, c, x);
  /* sends the values of the variables to the screen */

  return;
}
