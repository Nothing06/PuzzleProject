#include<stdio.h>

int main(void)
{
	int i = 0;
	int n = 0;
	int sum = 0;

	printf("n������ ¦���� ���� ����մϴ�.\n");
	
	do
	{
		printf("n�� �Է� : ");
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