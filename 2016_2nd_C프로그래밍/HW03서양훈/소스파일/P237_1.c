#include<stdio.h>

int AddToTotal(int num)
{
	static int total;
	total += num;
	return total;
}
int MultToTotal( int num)
{
	static int mult = 1;
	mult *= num;
	return mult;
}
int main(void)
{
	int num, i;
	for (i = 0; i < 3; i += 1)
	{
		printf("�Է�%d: ", i + 1);
		scanf("%d", &num);
		printf("����(��) : %d\n", AddToTotal(num));
		printf("����(��) : %d\n\n", MultToTotal(num));
	}
	return 0;
}