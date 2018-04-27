#include<stdio.h>

int main(void)
{
	int n1 = 0, n2 = 1;

	do
	{
		printf("두 정수를 입력(두번째 정수는 0이 아닌 정수 입력): ");
		scanf("%d %d", &n1, &n2);
		getchar();
	} while (n2 == 0);

	printf("몫: %d  나머지: %d\n", n1 / n2, n1%n2);
	return 0;
}