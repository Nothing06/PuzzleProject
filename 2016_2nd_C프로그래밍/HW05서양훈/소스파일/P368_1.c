#include<stdio.h>
#include<stdlib.h>

void MaxAndMin(int arr[], int len, int ** maxPtr, int ** minPtr)
{
	int i = 0;
	int j = 0;

	*maxPtr = &arr[0];
	*minPtr = &arr[0];
	**maxPtr = arr[0];
	**minPtr = arr[0];
	for (i = 0; i < len; i += 1)
	{
		if (**maxPtr < arr[i])
			*maxPtr = &arr[i];
		if (**minPtr > arr[i])
			*minPtr = &arr[i];
	}
}
void set_random_value(int arr[], int len) // 범위: 1~100(정수) 
{
	int i = 0;
	for (i = 0; i < len; i += 1)
		arr[i] = rand() % 100 + 1;
}
void print_numbers(int * p, int len)
{
	int i = 0;
	printf(" * 배열 원소 출력\n");
	for (i = 0; i < len; i += 1)
		printf("arr[%d] = %d\n",i, p[i]);
	printf("\n");
}
int main(void)
{
	int * maxPtr;
	int * minPtr;
	int arr[5];
	srand((unsigned)time(NULL));
	set_random_value(arr, 5);
	print_numbers(arr, 5);

	MaxAndMin(arr, 5, &maxPtr, &minPtr);
	printf("MAX: %d, MIN: %d\n", *maxPtr, *minPtr);
	return 0;
}