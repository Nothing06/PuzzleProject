#include<stdio.h>

int main(void)
{
	double n1 = 0;
	double n2 = 0;

	do
	{
		printf("�� ���� �Է�: ");
		scanf("%lf %lf", &n1, &n2);
		getchar();
	} while (n2 == 0); // n2�� 0�̸� Divide By Zero ������ ������ֱ� ������   ���Է½�Ű���� ��.

	printf("Plus : %lf\n", n1 + n2);
	printf("Minus : %lf\n", n1 - n2);
	printf("Mult : %lf\n", n1*n2);
	printf("Divide: %lf\n", n1 / n2);

	return 0;
}