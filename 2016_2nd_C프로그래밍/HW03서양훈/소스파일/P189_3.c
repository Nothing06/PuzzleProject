#include<stdio.h>

int main(void)
{
	unsigned int lang_score = 0;
	unsigned int math_score = 0;
	unsigned int eng_score = 0;
	double average = 0;
	int grade = 0;

	printf("���� ���� �Է�:");
	scanf("%u", &lang_score);
	printf("���� ���� �Է�:");
	scanf("%u", &math_score);
	printf("���� ���� �Է�:");
	scanf("%u", &eng_score);

	average = (double)(lang_score + math_score + eng_score) / 3;
	if (average >= 90)
	{
		grade = 'A';
	}
	else if (average >= 80)
	{
		grade = 'B';
	}
	else if (average >= 70)
	{
		grade = 'C';
	}
	else if (average >= 50)
	{
		grade = 'D';
	}
	else
	{
		grade = 'F';
	}
	printf("��� : %lf\n", average);
	printf("���� : %C\n", grade);
	return 0;
}