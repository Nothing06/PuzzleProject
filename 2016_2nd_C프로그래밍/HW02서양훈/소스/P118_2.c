#include<stdio.h>

int main(void)
{
	double n1 = 0;
	double n2 = 0;

	do
	{
		printf("두 수를 입력: ");
		scanf("%lf %lf", &n1, &n2);
		getchar();
	} while (n2 == 0); // n2가 0이면 Divide By Zero 문제가 생길수있기 때문에   재입력시키도록 함.

	printf("Plus : %lf\n", n1 + n2);
	printf("Minus : %lf\n", n1 - n2);
	printf("Mult : %lf\n", n1*n2);
	printf("Divide: %lf\n", n1 / n2);

	return 0;
}