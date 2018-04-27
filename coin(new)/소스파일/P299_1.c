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
	int arr2[3][3] = { 0, };
	int * ptrA[3] = { *arr2, *(arr2 + 1) };

	printf("sizeof(*arr2) : %d , sizeof(arr2[0]) : %d , sizeof(*ptrA) : %d\n", sizeof(*arr2), sizeof(arr2[0]), sizeof(*ptrA));

	ptr = arr;
	printf(" * Before Calculation\n");
	for (i = 0; i < sizeof(arr) / sizeof(int); i += 1)
	{
		printf("arr[%d] : %d\n", i, *ptr++);
	}

	ptr = arr;
	for (i = 0; i < sizeof(arr) / sizeof(int); i += 1)
	{
		*ptr++ += 2;
	}

	ptr = arr;
	printf(" * After Calculation1\n");
	for (i = 0; i < sizeof(arr) / sizeof(int); i += 1)
	{
		printf("arr[%d] : %d\n", i, *ptr++);
	}


	d_ptr = darr;
	for (i = 0; i < sizeof(darr) / sizeof(double); i += 1)
	{
		*d_ptr++ /= 2;
	}

	d_ptr = darr;
	printf(" * After Calculation2\n");
	for (i = 0; i < sizeof(darr) / sizeof(double); i += 1)
	{
		printf("darr[%d] : %.1lf\n", i, *d_ptr++);
	}
	return 0;
}