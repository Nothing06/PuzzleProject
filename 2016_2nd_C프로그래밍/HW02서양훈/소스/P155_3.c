#include<stdio.h>

int main(void)
{
	int i = 0;
	int num = 0;
	int sum = 0; // ��� ���� ��
	long mul = 1; // ��� ���� ��

	while (1)
	{
		printf("���� �Է�: ");
		scanf("%d", &num);
		getchar();
		if (num == 0)
			break;
		sum += num;
		mul *= num;
	}
	printf("sum : %d\n", sum);
	printf("mul : %ld\n", mul);
	return 0;
}