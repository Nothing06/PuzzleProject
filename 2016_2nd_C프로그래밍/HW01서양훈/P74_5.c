#include<stdio.h>

int main(void)
{
	int num1 = 0, num2 = 0, num3 = 0;

	printf("세 개의 정수를 순서대로 입력(ex.11 2 8): ");
	scanf("%d %d %d", &num1, &num2, &num3);
	
	printf("실험결과 : %d\n", (num1 + num2)*(num2 % num3)*(num3-num1));
	printf("결과 : %d\n", (num1 - num2)*(num2 + num3)*(num3%num1));
	return 0;
}