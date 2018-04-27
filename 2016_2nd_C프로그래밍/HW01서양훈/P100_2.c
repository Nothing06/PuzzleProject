#include<stdio.h>

int main(void)
{
	int num = 3;

	num <<= 3;
	num >>= 2;
	printf("3 X 8 / 4 = %d\n", num);

	num = 5;
	num <<= 2;
	num >>= 1;
	printf("5 X 4 / 2 = %d\n", num);
	return 0;
}