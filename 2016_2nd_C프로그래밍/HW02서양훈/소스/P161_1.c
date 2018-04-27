#include<stdio.h>

int main(void)
{
	int total = 0, num = 0;
	int mult = 1;

	num = 1;
	printf("정수 입력(0 to quit): ");
	scanf("%d", &num);
	total += num;
	if(num!=0)
	mult *= num;
	while (num !=0)
	{
		printf("정수 입력(0 to quit): ");
		scanf("%d", &num);
		total += num;
		if (num != 0)
			mult *= num;
		else
			break;
	}
	printf("total : %d\n", total);
	printf("mult : %d\n", mult);

	return 0;
}