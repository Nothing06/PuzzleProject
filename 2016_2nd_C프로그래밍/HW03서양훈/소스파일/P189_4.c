#include<stdio.h>

int main(void)
{
	unsigned int lang_score = 0;
	unsigned int math_score = 0;
	unsigned int eng_score = 0;
	double average = 0;
	int grade = 0;


	int gap = 0;//�μ�����
	int n1 = 0;
	int n2 = 0;
	int bigger = 0;
	int smaller = 0;


	printf("���� ���� �Է�:");
	scanf("%u", &lang_score);
	printf("���� ���� �Է�:");
	scanf("%u", &math_score);
	printf("���� ���� �Է�:");
	scanf("%u", &eng_score);

	average = (double)(lang_score + math_score + eng_score) / 3;
	grade = (average >= 90 ? 'A' : ((average >= 80) ? 'B' : (average>=70 ? 'C' : (average>=50 ? 'D' : 'F' ))));
	
	printf("1. ��� : %lf\n", average);
	printf("2. ���� : %C\n", grade);



	printf("�� ���� �Է�: ");
	scanf("%d %d", &n1, &n2);

	bigger = (n1 > n2 ? n1 : n2);
	smaller = (n1 < n2 ? n1 : n2);
	gap = (bigger - smaller);
	printf("�μ��� ��: %d\n", gap);
	return 0;
}