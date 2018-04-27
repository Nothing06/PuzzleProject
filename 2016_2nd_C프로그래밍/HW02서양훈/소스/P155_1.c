#include<stdio.h>

void Hello_world()
{
	printf("Hello world!\n");
}
int main(void)
{
	int i = 0;
	int cnt = 0;

	do {
		printf("양의정수를 입력하시오 : ");
		scanf("%d", &cnt);
		getchar();
	} while (cnt <= 0); // 0 이하의 숫자일 경우 재입력.

	for (i = 0; i < cnt; i += 1)
		Hello_world();
	return 0;
}