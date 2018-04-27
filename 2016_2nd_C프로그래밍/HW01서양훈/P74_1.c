#include<stdio.h>
int main(void)
{
	int n1 = 0, n2 = 0;

	printf("두개의 정수 입력: ");
	scanf("%d %d", &n1, &n2);
	getchar(); // '\n' 제거

	printf("%d - %d = %d\n", n1, n2, n1 - n2);
	printf("%d X %d = %d\n", n1, n2, n1 * n2);
	printf("%d + %d = %d\n", n1, n2, n1+n2);
	return 0;
}