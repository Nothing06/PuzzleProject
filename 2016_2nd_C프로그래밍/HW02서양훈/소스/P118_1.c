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

	printf("좌 상단의 x,y좌표가 우 하단의 x,y좌표보다 값이 크거나 같으면 재입력.\n");
	do
	{
		printf("1. 좌 상단의 x,y 좌표: ");
		scanf("%lf %lf", &x1, &y1);
		getchar(); //buffer제거

		printf("2. 우 하단의 x,y 좌표: ");
		scanf("%lf %lf", &x2, &y2);
		getchar(); // buffer제거
		printf("\n");
	} while (x1 >= x2 || y1 >= y2);

	area = (y2 - y1) * (x2 - x1);
	
	printf("두 점이 이루는 직사각형의 넓이는 %lf입니다.\n", area);
	return 0;
}