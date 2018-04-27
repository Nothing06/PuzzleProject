#include<stdio.h>

int main(void)
{
	int num1 = 0;
	int num2 = 0;
	int num3 = 0;
	int tmp1 = 0;
	int tmp2 = 0;
	int tmp3 = 0;
	int n = 0;

	do {
		printf("num1 num2 num3(0 0 0 입력시 종료): ");
		scanf("%d %d %d", &num1, &num2, &num3);
		getchar();
		if (num1 == 0 && num2 == 0 && num3 == 0)
		{
			printf("Exit!\n");
			break;
		}
		tmp1 = num1;
		tmp2 = num2;
		tmp3 = num3;

		num2 = tmp1;
		num3 = tmp2;
		num1 = tmp3;

		printf("num1 : %d\n", num1);
		printf("num2 : %d\n", num2);
		printf("num3 : %d\n", num3);
		printf("\n");
	} while (1);
	return 0;
}