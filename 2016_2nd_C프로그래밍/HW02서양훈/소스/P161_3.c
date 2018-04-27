#include<stdio.h>
#include<stdlib.h>
#include<string.h>

int main(void)
{
	int cur = 2;
	int i, j;
	i = 0; j = 0;

	do
	{
		j = 1;
		do
		{
			printf("%d X %d = %d   ", cur, j, cur*j);
			j += 1;
		} while (j <= 9);
		printf("\n");
		cur += 1;
	} while (cur <= 9);
	return 0;
}