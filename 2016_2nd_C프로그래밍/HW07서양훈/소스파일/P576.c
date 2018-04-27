#include<stdio.h>
#include<stdlib.h>
#define ADD(x,y,z) (x+y+z)
#define MULT(x,y,z) ((x)*(y)*(z))

#define PI 3.141592
#define AREA(x) (x*x*PI)

#define MAX(a,b) (a < b ? b : a)
#define MIN(a,b) (a < b ? a : b)

#define PRINT(ADDR) printf("당신의 집은 " #ADDR "입니다\n")

int main(void)
{
	int a = 0, b = 0;

	srand((unsigned)time(NULL));

	PRINT("서울시 강동구");
	printf("원의 넓이: %lf\n", AREA(3));
	a = rand() % 1000;
	b = rand() % 1000;
	printf("MAX(%d,%d): %d\n",a, b, MAX(a, b));
	printf("MIN(%d,%d): %d\n",a, b, MIN(a, b));
	return 0;
}