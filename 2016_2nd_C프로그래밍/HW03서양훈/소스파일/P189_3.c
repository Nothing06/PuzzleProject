#include<stdio.h>

int main(void)
{
	unsigned int lang_score = 0;
	unsigned int math_score = 0;
	unsigned int eng_score = 0;
	double average = 0;
	int grade = 0;

	printf("국어 점수 입력:");
	scanf("%u", &lang_score);
	printf("수학 점수 입력:");
	scanf("%u", &math_score);
	printf("영어 점수 입력:");
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
	printf("평균 : %lf\n", average);
	printf("학점 : %C\n", grade);
	return 0;
}