#include<stdio.h>
#include<stdlib.h>
// 단계별로 보여주기
int main(void)
{
	int num1 = 10;
	int num2 = 20;
	int * ptr1 = &num1;
	int * ptr2 = &num2;
	int * tmp;

	printf("Before Calculating by ptr>>(포인터가 참조하는 메모리값) ptr1: %d, ptr2: %d\n", *ptr1, *ptr2);
	*ptr1 += 10;
	*ptr2 -= 10;
	printf("After Calculating by ptr>>(포인터가 참조하는 메모리값) ptr1: %d, ptr2: %d\n", *ptr1, *ptr2);

	printf("Before Swap >> ptr1 : %d, ptr2 : %d\n", *ptr1, *ptr2);
	tmp = ptr1;
	ptr1 = ptr2;
	ptr2 = tmp;


	printf("After Swap >> ptr1 : %d, ptr2 : %d\n", *ptr1, *ptr2);

	return 0;
}