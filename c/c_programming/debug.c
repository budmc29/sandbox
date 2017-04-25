#include <stdio.h>
#define DEBUG 2

int main()
{

  #if DEBUG == 1
    printf("Debug status is 1\n");
  #elif DEBUG == 2
    printf("Debug status is 2\n");
  #else
    printf("Default debug status")
  #endif

  #undef DEBUG

  #ifndef DEBUG
    printf("Debug is OFF\n");
  #endif

  return 0;

}
