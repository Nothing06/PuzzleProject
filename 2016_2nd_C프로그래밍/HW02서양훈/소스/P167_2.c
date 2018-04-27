#include<stdio.h>
unsigned int fact(int n)
{
	int i = 0;
	int result = 1;
	
	if (n == 0 || n==1)
		return 1;
	for (i = 1; i <= n; i += 1)
		result *= i;
	return result;
}
int main(void)
{
	int n = -1;
	

	for (; n < 0; ) // n이 0이상의 값만 받을수있도록  반복문을 사용해  재입력.
	{
		printf("n을 입력(n!): ");
		scanf("%d", &n);
	}

	printf("%d\n", fact(n));
	return 0;
}