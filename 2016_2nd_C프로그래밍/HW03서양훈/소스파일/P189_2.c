#include<stdio.h>

int main(void)
{
	int sum = 0;//�μ�����
	int gap = 0;//�μ�����
	int n1 = 0;
	int n2 = 0;
	int bigger = 0;
	int smaller = 0;

	printf("�� ���� �Է�: ");
	scanf("%d %d", &n1, &n2);

	bigger = (n1 > n2 ? n1 : n2);
	smaller = (n1 < n2 ? n1 : n2);
	sum = (n1 + n2);
	gap = (bigger - smaller);
	printf("�μ��� ��: %d\n",sum);
	printf("�μ��� ��: %d\n", gap);
	return 0;
}