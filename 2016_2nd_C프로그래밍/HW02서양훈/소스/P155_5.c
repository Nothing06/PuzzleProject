#include<stdio.h>

int main(void)
{
	int cnt = 0;
	int i = 0;
	int n = 0;
	int sum = 0;
	int mul = 1;
	double average = 0;

	printf("입력할 정수들의 개수 입력: ");
	scanf("%d", &cnt);
	for (i = 0; i < cnt; i += 1)
	{
		printf("정수 입력: ");
		scanf("%d", &n);
		sum += n;
		mul *= n;
	}
	average = (double)sum / cnt;
	printf("평균 : %.3lf\n", average);
	printf("전부 곱한 값: %d\n", mul);
	return 0;
}