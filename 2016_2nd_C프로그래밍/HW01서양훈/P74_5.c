#include<stdio.h>

int main(void)
{
	int num1 = 0, num2 = 0, num3 = 0;

	printf("�� ���� ������ ������� �Է�(ex.11 2 8): ");
	scanf("%d %d %d", &num1, &num2, &num3);
	
	printf("������ : %d\n", (num1 + num2)*(num2 % num3)*(num3-num1));
	printf("��� : %d\n", (num1 - num2)*(num2 + num3)*(num3%num1));
	return 0;
}