#include<stdio.h>

int main(void)
{
	int cnt = 0;
	int i = 0;
	int n = 0;
	int sum = 0;
	int mul = 1;
	double average = 0;

	printf("�Է��� �������� ���� �Է�: ");
	scanf("%d", &cnt);
	for (i = 0; i < cnt; i += 1)
	{
		printf("���� �Է�: ");
		scanf("%d", &n);
		sum += n;
		mul *= n;
	}
	average = (double)sum / cnt;
	printf("��� : %.3lf\n", average);
	printf("���� ���� ��: %d\n", mul);
	return 0;
}