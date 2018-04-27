#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<math.h>

typedef struct point
{
	int xpos;
	int ypos;
}Point;
typedef struct rec
{
	Point left_top;
	Point right_bot;
}Rectangle;
int get_Area(Rectangle * p)
{
	int i, j;
	int area = 0;
	area = (p->right_bot.xpos - p->left_top.xpos) * (p->left_top.ypos - p->right_bot.ypos);
	printf("area : %d\n\n", area);
	return area;
}
double get_distance(Rectangle * p)//왼쪽상단 좌표와 우측하단 좌표의 거리
{
	int i = 0;
	double dis = 0;
	
	dis = sqrt( pow((p->right_bot.xpos - p->left_top.xpos), 2) + pow((p->left_top.ypos - p->right_bot.ypos),2));
	return dis;
}
void print_pos(Point p1, Point p2)
{
	int i, j;
	printf("p1) x: %d y: %d\n", p1.xpos, p1.ypos);
	printf("p2) x: %d y: %d\n", p2.xpos, p2.ypos);
	printf("\n");
}
void menu()
{
	printf("1. 두 점의 좌표 출력\n");
	printf("2. 두 점이 이루는 직사각형 넓이 출력\n");
	printf("3. 두 점 사이의 거리 출력\n");
	printf("선택(1 or 2 or 3)>>");
}
int main(void)
{
	Point p1 = { 20,40 };
	Point p2 = { 40,20 };
	int left = 0;
	int top = 0;
	int right = 0;
	int bottom = 0;

	Rectangle r = { p1, p2 };
	int c = 0;
	int exit = 0;

	do {
		menu();
		scanf("%d", &c);
		getchar();
		
		switch (c)
		{
		case 1:
			print_pos(p1, p2);
			break;
		case 2:
			get_Area(&r);
			break;
		case 3:
			printf("두 점 사이의 거리 : %lf\n\n",get_distance(&r));
			break;
		default: 
			exit = 1;
			break;
		}
		if (exit == 1)
			break;
	} while (1);

	return 0;
}