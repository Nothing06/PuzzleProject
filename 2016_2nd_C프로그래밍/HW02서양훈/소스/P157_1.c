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
		printf("5���� ������ 1���� �Է�: ");
		scanf("%d", &n);
		getchar();
		if (n < 1)
			continue;
		sum += n;
		i += 1;
	}
	average = (double)sum / 5;

	printf("���� : %d\n", sum);
	printf("��� : %.3lf\n", average);
	return 0;
}