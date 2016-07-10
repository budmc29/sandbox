/* Filename: c2first.c
   Requests a name, prints the name 5 times, and rings a bell */

#include <stdio.h>
#define BELL '\a'

main()
{
  int ctr=0;
  char fname[20];

  printf("What is your name?");
  scanf(" %s", fname);
  while (ctr < 5)
  {
    printf("%s\n", fname);
    ctr++;
  }
  printf("%c", BELL);
  return;
}

