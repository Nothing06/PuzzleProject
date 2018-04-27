#include<stdio.h>
#include<limits.h>
int main(void)
{
	int arr[5] = { 0, };
	int sum = 0;
	int max = INT_MIN;
	int min = INT_MAX;
	double average = 0; //평균값 추가
	int i = 0;
	
	for (i = 0; i < 5; i += 1)
	{
		printf("정수%d 입력: ", i + 1);
		scanf("%d", &arr[i]);

		if (max < arr[i])
			max = arr[i];
		if (min > arr[i])
			min = arr[i];
		sum += arr[i];
		
	}
	average = (double)sum / 5;

	printf("MAX : %d\n", max);
	printf("MIN : %d\n", min);
	printf("sum : %d\n", sum);
	printf("AVG : %lf\n", average);
	return 0;
}