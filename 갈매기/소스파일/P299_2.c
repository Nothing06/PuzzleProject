#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<math.h>

int main(void)
{
	int arr[5] = { 1,2,3,4,5 };
	double darr[5] = { 1,3,5,7,9 };
	int i = 0;
	int * ptr;
	double * d_ptr;

	ptr = arr;
	d_ptr = darr;

	printf(" * Before Calculation\n");
	for (i = 0; i < sizeof(arr) / sizeof(int); i += 1)
	{
		printf("arr[%d] : %d\n", i, *(ptr+i));
	}
	printf("\n");
	for (i = 0; i < sizeof(darr) / sizeof(double); i += 1)
	{
		printf("darr[%d] : %lf\n", i, *(d_ptr + i));
	}


	for (i = 0; i < sizeof(arr) / sizeof(int); i += 1)
	{
		*(ptr+i) += 2;
	}


	printf(" * After Calculation1\n");
	for (i = 0; i < sizeof(arr) / sizeof(int); i += 1)
	{
		printf("arr[%d] : %d\n", i, *(ptr+i));
	}

	for (i = 0; i < sizeof(darr) / sizeof(double); i += 1)
	{
		*(d_ptr+i) /= 2;
	}

	printf(" * After Calculation2\n");
	for (i = 0; i < sizeof(darr) / sizeof(double); i += 1)
	{
		printf("darr[%d] : %.1lf\n", i, *(d_ptr+i));
	}
	return 0;
}