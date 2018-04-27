#include<stdio.h>

int main(void)
{
	int i = 0;
	int num = 0;
	int sum = 0; // 모두 합한 수
	long mul = 1; // 모두 곱한 수

	while (1)
	{
		printf("정수 입력: ");
		scanf("%d", &num);
		getchar();
		if (num == 0)
			break;
		sum += num;
		mul *= num;
	}
	printf("sum : %d\n", sum);
	printf("mul : %ld\n", mul);
	return 0;
}