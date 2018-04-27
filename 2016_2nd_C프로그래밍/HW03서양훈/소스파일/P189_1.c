#include<stdio.h>
#define N 100
//5 7 9의 배수를 출력.
int main(void)
{
	int i = 1;
	int five_x[N] = { 0, };
	int seven_x[N] = { 0, };
	int nine_x[N] = { 0, };
	int five_idx = 0;
	int seven_idx = 0;
	int nine_idx = 0;

	while (i < 100)
	{
		if (i % 5==0 && i%7==0)
		{
			printf("%d ", i);
		}
		else if(i % 5 == 0 && i % 9 == 0)
		{
			printf("%d ", i);
		}
		if (i % 7 == 0 && i % 9 == 0)
		{
			printf("%d ", i);
		}
		else if (i % 5 == 0)
		{
			five_x[five_idx++] = i;
			printf("%d ", i);
		}
		else if (i % 7 == 0)
		{
			seven_x[seven_idx++] = i;
			printf("%d ", i);
		}
		else if (i % 9 == 0)
		{
			nine_x[nine_idx++] = i;
			printf("%d ", i);
		}
		i += 1;
		if (i % 10 == 0)
			printf("\n");
	}

	return 0;
}