#include<stdio.h>

int main(void)
{
	int n1 = 0, n2 = 1;

	do
	{
		printf("�� ������ �Է�(�ι�° ������ 0�� �ƴ� ���� �Է�): ");
		scanf("%d %d", &n1, &n2);
		getchar();
	} while (n2 == 0);

	printf("��: %d  ������: %d\n", n1 / n2, n1%n2);
	return 0;
}