#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<math.h>
#include<time.h>
#define MAX_NUM 100


void set_random_intArr(int * parr, int len)
{
	int i = 0;
	srand(time(NULL));
	for (i = len-1; i >=0; i -= 1)
	{
		*(parr--) = ((rand() % MAX_NUM) +1);
	}
}
void set_random_doubleArr(double * parr, int len)
{
	int i = 0;
	for (i = len - 1; i >= 0; i -= 1)
	{
		*(parr--) = ((rand() % MAX_NUM)/2.0) + 1;
	}
}

int main(void)
{
	int arr[5] = {0,};
	double darr[5] = { 0.0, };
	int i = 0;

	int * ptr;
	double * d_ptr;
	
	int sum = 0;
	double dsum = 0;
	int len = 0;
	int dlen = 0;

	sum = 0;
	dsum = 0;

	ptr = arr+4;
	d_ptr = darr+4;
	dlen = sizeof(darr) / sizeof(double);
	len = sizeof(arr) / sizeof(int);
	//printf("sizeof(darr): %d, sizeof(double) : %d, dlen: %d\n", sizeof(darr), sizeof(double), dlen);
//	printf("len : %d\n", len);

	srand((unsigned)time(NULL));
	set_random_intArr(ptr, len);
	printf("\n");
	set_random_doubleArr(d_ptr, dlen);
	ptr = arr + 4;
//	printf("arr+4 : %d\n", *ptr);
	d_ptr = darr + 4;
//	printf("darr+4 : %lf\n", *d_ptr);

	printf(" * Show Array Numbers\n");
	for (i = len-1; i >=0; i -= 1)
	{
		printf("arr[%d] : %d\n", i, *(ptr--));
	}
	printf("\n");
	for (i = dlen-1; i >=0; i -= 1)
	{
		printf("darr[%d] : %lf\n", i, *(d_ptr--));
	}

	d_ptr = darr+4;
	ptr = arr+4;
	for (i = len-1; i >=0; i -= 1)
	{
		sum += *(ptr--);
	}

	for (i = dlen - 1; i >= 0; i -= 1)
	{
		dsum += *(d_ptr--);
	}

	printf(" * After Calculation\n");
	printf(" intÇü Array sum : %d\n",sum);
	printf(" doubleÇü Array sum : %lf\n",dsum);
	return 0;
}