#include<stdio.h>

int main(void)
{
	int i = 0;
	int sum = 0;
	int n;
	double average = 0;

	while (i<5)
	{
		n = 0;
		printf("5개의 정수를 1개씩 입력: ");
		scanf("%d", &n);
		getchar();
		if (n < 1)
			continue;
		sum += n;
		i += 1;
	}
	average = (double)sum / 5;

	printf("총합 : %d\n", sum);
	printf("평균 : %.3lf\n", average);
	return 0;
}