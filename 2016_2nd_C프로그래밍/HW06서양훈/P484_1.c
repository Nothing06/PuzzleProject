#include<stdio.h>
#include<stdlib.h>
#include<string.h>

typedef struct point
{
	int xpos;
	int ypos;
}Point;

Point pos1 = { 2,4 };
Point pos2 = { 5,7 };

void swapPoint(Point * a, Point * b, Point * c)
{
	Point t = { 0, };
	Point t2;

	t = *a;
	t2 = *b;

	*a = t2;
	*b = *c;
	*c = t;
}
void show_pos(Point p)
{
	printf("x: %d  y: %d\n", p.xpos, p.ypos);
}
int main(void)
{
	Point pos1 = { 2,4 };
	Point pos2 = { 5,7 };
	Point pos3 = { 3,9 };

	printf("* Before Swap\n");
	show_pos(pos1);
	show_pos(pos2);
	show_pos(pos3);

	swapPoint(&pos1, &pos2, &pos3);
	printf("* After Swap\n");
	show_pos(pos1);
	show_pos(pos2);
	show_pos(pos3);
	return 0;
}