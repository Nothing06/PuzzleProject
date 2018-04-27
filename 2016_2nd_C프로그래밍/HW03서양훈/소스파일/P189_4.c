#include<stdio.h>

int main(void)
{
	unsigned int lang_score = 0;
	unsigned int math_score = 0;
	unsigned int eng_score = 0;
	double average = 0;
	int grade = 0;


	int gap = 0;//두수의차
	int n1 = 0;
	int n2 = 0;
	int bigger = 0;
	int smaller = 0;


	printf("국어 점수 입력:");
	scanf("%u", &lang_score);
	printf("수학 점수 입력:");
	scanf("%u", &math_score);
	printf("영어 점수 입력:");
	scanf("%u", &eng_score);

	average = (double)(lang_score + math_score + eng_score) / 3;
	grade = (average >= 90 ? 'A' : ((average >= 80) ? 'B' : (average>=70 ? 'C' : (average>=50 ? 'D' : 'F' ))));
	
	printf("1. 평균 : %lf\n", average);
	printf("2. 학점 : %C\n", grade);



	printf("두 수를 입력: ");
	scanf("%d %d", &n1, &n2);

	bigger = (n1 > n2 ? n1 : n2);
	smaller = (n1 < n2 ? n1 : n2);
	gap = (bigger - smaller);
	printf("두수의 차: %d\n", gap);
	return 0;
}