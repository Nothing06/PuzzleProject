#include<stdio.h>

int main(void)
{
	int i = 0;
	int j = 0;

	while (i < 5)
	{
		j = 0;
		while(j<i)
		{
			printf("O");
			j += 1;
		}
		printf("*\n");
		i += 1;
	}
	printf("\n");

	i = 1; j = 0;
	while (i < 5)
	{
		j = i;
		while (j<5)
		{
			printf("O");
			j += 1;
		}
		printf("*\n");
		i += 1;
	}
	return 0;
}