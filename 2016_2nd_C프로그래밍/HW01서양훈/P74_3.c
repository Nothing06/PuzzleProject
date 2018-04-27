#include<stdio.h>
#define SQRT(n) (n)*(n)

int main(void)
{
	int n = 0;

	printf("정수 입력: ");
	scanf("%d", &n);

	printf("SQRT(n) = %d\n",SQRT(n));
	printf("세제곱 : %d\n", n*n*n);
	return 0;
}