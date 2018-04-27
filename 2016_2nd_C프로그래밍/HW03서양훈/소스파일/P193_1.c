#include<stdio.h>
//문제에서는 짝수단만 했지만 
//추가실험에서는 홀수단 추가수행

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