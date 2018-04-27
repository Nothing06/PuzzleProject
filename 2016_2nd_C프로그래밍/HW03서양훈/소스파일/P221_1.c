#include<stdio.h>
#include<limits.h>
int get_Max(int n1, int n2, int n3)
{
	int max = 0;
	max = (n1 < n2 ? (n2 < n3 ? n3 : n2) : (n1 < n3 ? n3 : n1));
	return max;
}
int get_Min(int n1, int n2, int n3)
{
	int min = 0;
	min = (n1 < n2 ? (n1 < n3 ? n1 : n3) : (n2 < n3 ? n2 : n3));
	return min;
}
int main(void)
{
	int n1 = 0, n2 = 0, n3 = 0;
	int max = 0;
	int min = 0;

	printf("세개의 정수 입력(INT_MAX: %d, INT_MIN: %d): ",INT_MAX, INT_MIN);
	scanf("%d %d %d", &n1, &n2, &n3);

	max = get_Max(n1, n2, n3);
	min = get_Min(n1, n2, n3);

	printf("Max : %d\n", max);
	printf("Min : %d\n", min);
	return 0;
}