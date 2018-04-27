#include<stdio.h>
#include<stdlib.h>
#include<string.h>
void get_subject_sum(int(*p)[5])
{
	int i = 0, j = 0;
	int sum = 0;
	for (j = 0; j < 5; j += 1)
	{
		sum = 0;
		for (i = 0; i < 5; i += 1)
		{
			sum += p[i][j];
		}
		p[4][j] = sum;
	}
}
void show_arr2(int(*p)[5])
{
	int i, j;
	for (i = 0; i < 5; i += 1)
	{
		for (j = 0; j < 5; j += 1)
		{
			printf("%3d ", p[i][j]);
		}
		printf("\n");
	}
}
int main(void)
{
	int arr[5][5] = { 0, };
	int i, j;
	int sum = 0;

	for (i = 0; i < 4; i += 1)
	{
		sum = 0;
		printf(" %d번 학생 점수 입력\n",i+1);
		for (j = 0; j < 4; j += 1)
		{
			switch (j)
			{
			case 0:
				printf("국어 점수: ");
				break;
			case 1:
				printf("영어 점수: ");
				break;
			case 2:
				printf("수학 점수: ");
				break;
			case 3:
				printf("국사 점수: ");
				break;
			
			}
			scanf("%d", &arr[i][j]);
			sum += arr[i][j];
		}
		arr[i][4] = sum;
	}
	get_subject_sum(arr);
	show_arr2(arr);
	return 0;
}