#include<stdio.h>

int main(void)
{
	int n1 = 0;
	int n2 = 0;

	printf("���� �Է�: ");
	scanf("%d %d", &n1,&n2);
	
	n1 = ~n1;
	n1 += 1;
	printf("%d\n", n1,n2);//n1�� 2�Ǻ��� ,  n2�� �Է°�. 

	return 0;
}