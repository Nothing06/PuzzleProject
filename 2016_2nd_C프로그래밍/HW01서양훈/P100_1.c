#include<stdio.h>

int main(void)
{
	int n1 = 0;
	int n2 = 0;

	printf("정수 입력: ");
	scanf("%d %d", &n1,&n2);
	
	n1 = ~n1;
	n1 += 1;
	printf("%d\n", n1,n2);//n1은 2의보수 ,  n2는 입력값. 

	return 0;
}