#include<stdio.h>
int main(void)
{
	int num1 = 0;
	int num2 = 0;
	int num3 = 0;

	printf("세 개의 정수를 차례대로 입력(ex. 1 2 3): ");
	scanf("%d %d %d", &num1, &num2, &num3);

	printf("%dX%d+%d = %d\n", num1, num2, num3, num1*num2 + num3);
	printf("%d+%dX%d = %d\n", num1, num2, num3, num1+num2 * num3);
	return 0;
}