#include<stdio.h>
#include<limits.h>

int fibo(int n)
{
	int t1 = 0;
	int t2 = 1;
	int t3 = 0;
	int i = 0;

	if (n <= 0)
		return 0;
	else if (n == 1)
	{
		printf("0\n");
		return 0;
	}
	else if (n == 2)
	{
		printf("0\t1\n");
		return 0;
	}

	printf("0\t1\t");
	for (i = 2; i < n; i += 1)
	{
		t3 = t1 + t2;
		if (INT_MAX - t2 < t1)
		{
			printf("INTEGER OVERFLOW!\n");
			return 0;
		}
		printf("%d\t", t3);
		if (i % 10 == 0)
			printf("\n");
		t1 = t2;
		t2 = t3;
	}
}
int main(void)
{
	int n = 0;
	while (1)
	{
		printf("피보나치 몇개 출력할지 개수 입력: ");
		scanf("%d", &n);
		getchar();
		if (n < 0)
			break;
		fibo(n);
		printf("\n");
	}
	return 0;
}