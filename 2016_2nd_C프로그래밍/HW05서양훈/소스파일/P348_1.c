#include<stdio.h>
#include<stdlib.h>

int main(void)
{
	int arr[9][9] = { 0, };
	int i, j;
	int num = 2;

	for (i = 0; i < 9; i += 1)
	{
		for (j = 0; j < 9; j += 1)
		{
			arr[i][j] = num*(j + 1);
			printf("%3d", arr[i][j]);
		}
		num += 1;
		printf("\n");
	}
	return 0;
}