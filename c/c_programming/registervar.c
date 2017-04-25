#include <stdio.h>
#include <time.h>

int main()
{
  // Stores the var in registers
  register int reg = 0;

  // Don't allow to store this variable in registers
  volatile int vol = 0;

  float startTime = (float)clock()/CLOCKS_PER_SEC;

  while ( reg < 800000000)
  {
    ++reg;
  }

  float endTime = (float)clock()/CLOCKS_PER_SEC;
  float timeElapsed = endTime - startTime;

  float startTimeVol = (float)clock()/CLOCKS_PER_SEC;

  while ( vol < 800000000)
  {
    ++vol;
  }

  float endTimeVol = (float)clock()/CLOCKS_PER_SEC;
  float timeElapsedVol = endTimeVol - startTimeVol;

  printf("Register time: %f\n", timeElapsed);
  printf("Volatile time: %f\n", timeElapsedVol);

  return 0;

}
