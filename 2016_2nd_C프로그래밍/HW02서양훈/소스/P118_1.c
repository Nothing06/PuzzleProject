#include<stdio.h>
#include<stdlib.h>
#include<string.h>

int main(void)
{
	double x1 = 0;
	double y1 = 0;
	double x2 = 0;
	double y2 = 0;
	double area = 0;

	printf("�� ����� x,y��ǥ�� �� �ϴ��� x,y��ǥ���� ���� ũ�ų� ������ ���Է�.\n");
	do
	{
		printf("1. �� ����� x,y ��ǥ: ");
		scanf("%lf %lf", &x1, &y1);
		getchar(); //buffer����

		printf("2. �� �ϴ��� x,y ��ǥ: ");
		scanf("%lf %lf", &x2, &y2);
		getchar(); // buffer����
		printf("\n");
	} while (x1 >= x2 || y1 >= y2);

	area = (y2 - y1) * (x2 - x1);
	
	printf("�� ���� �̷�� ���簢���� ���̴� %lf�Դϴ�.\n", area);
	return 0;
}