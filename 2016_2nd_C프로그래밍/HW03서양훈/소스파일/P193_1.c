#include<stdio.h>
//���������� ¦���ܸ� ������ 
//�߰����迡���� Ȧ���� �߰�����

int main(void)
{
	int i = 1;
	int j = 1;
	while (i < 10)
	{
		if (i % 2 == 1)
		{
			i += 1;
			continue;
		}
		j = 1;
		while (j < 10)
		{
			printf("%dX%d = %d  ", i, j, i*j);
			if (j == i)break;
			j += 1;
		}
		i += 1;
		printf("\n");
	}
	
	printf("\n");

	i = 1; j = 1;
	while (i < 10)
	{
		if (i % 2 == 0)
		{
			i += 1;
			continue;
		}
		j = 1;
		while (j < 10)
		{
			printf("%dX%d = %d  ", i, j, i*j);
			if (j == i)break;
			j += 1;
		}
		i += 1;
		printf("\n");
	}
	return 0;
}