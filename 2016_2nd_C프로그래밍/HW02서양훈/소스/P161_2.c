#include<stdio.h>

int main(void)
{
	int i = 0;
	int n = 0;
	int sum = 0;

	printf("n까지의 짝수의 합을 출력합니다.\n");
	
	do
	{
		printf("n을 입력 : ");
		scanf("%d", &n);
	} while (n < 0);

	do{
		if(!(i%2))
			sum += i;
		i += 1;
	} while (i <= n);
	printf("sum : %d\n", sum);
	return 0;
}