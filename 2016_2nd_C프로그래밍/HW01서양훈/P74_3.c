#include<stdio.h>
#define SQRT(n) (n)*(n)

int main(void)
{
	int n = 0;

	printf("���� �Է�: ");
	scanf("%d", &n);

	printf("SQRT(n) = %d\n",SQRT(n));
	printf("������ : %d\n", n*n*n);
	return 0;
}