#include<stdio.h>

int main(void)
{
	int sum = 0;//두수의합
	int gap = 0;//두수의차
	int n1 = 0;
	int n2 = 0;
	int bigger = 0;
	int smaller = 0;

	printf("두 수를 입력: ");
	scanf("%d %d", &n1, &n2);

	bigger = (n1 > n2 ? n1 : n2);
	smaller = (n1 < n2 ? n1 : n2);
	sum = (n1 + n2);
	gap = (bigger - smaller);
	printf("두수의 합: %d\n",sum);
	printf("두수의 차: %d\n", gap);
	return 0;
}