#include<stdio.h>
#include<stdlib.h>

int SquareByValue(int n)
{
	int pow = n*n;
	if (pow / n != n) // pow���� ���ǹ����� �ʰ��Ұ��(�����⸦ �ؼ� ���Ѱ��� �´��� �˻�), overflow�����, 0��ȯ.
	{
		printf("overflow!\n");
		return 0;
	}
	return pow;
}
int SquareByReference(const int * n)
{
	int num = (*n);
	int pow = (num)*(num);

	if (pow / (num) != num) //pow���� ���ǹ����� �ʰ��Ұ��(�����⸦ �ؼ� ���Ѱ��� �´��� �˻�), overflow�����, 0��ȯ.
	{
		printf("overflow!\n");
		return 0;
	}
	return pow;
}
int main(void)
{
	int num = 0;

	do {
			printf("������ �� �Է�(0�Է½� ����): ");
			scanf("%d", &num);
			getchar();
			if (num == 0)
			{
				printf("���α׷� ����.\n");
				break;
			}
			printf("SquareByValue : %d\n", SquareByValue(num));
			printf("SquareByReference : %d\n", SquareByReference(&num));
			printf("\n");
	} while (1);
	return 0;
}