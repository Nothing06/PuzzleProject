#include<stdio.h>
#include<stdlib.h>

int SquareByValue(int n)
{
	int pow = n*n;
	if (pow / n != n) // pow값이 값의범위를 초과할경우(나누기를 해서 곱한값이 맞는지 검사), overflow출력후, 0반환.
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

	if (pow / (num) != num) //pow값이 값의범위를 초과할경우(나누기를 해서 곱한값이 맞는지 검사), overflow출력후, 0반환.
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
			printf("제곱할 수 입력(0입력시 종료): ");
			scanf("%d", &num);
			getchar();
			if (num == 0)
			{
				printf("프로그램 종료.\n");
				break;
			}
			printf("SquareByValue : %d\n", SquareByValue(num));
			printf("SquareByReference : %d\n", SquareByReference(&num));
			printf("\n");
	} while (1);
	return 0;
}