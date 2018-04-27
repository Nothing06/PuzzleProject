#include<stdio.h>

int main(void)
{
	char c = 1;

	printf("아스키코드값 출력\n");
	do
	{
		printf("0~127 중의 수를 입력: ");
		scanf("%c", &c);
	} while (c < 0 || c > 127); // 0~127 범위가 아닐 경우 재입력.
	printf("%c의 ASCII CODE값: %d\n", c, c);
	return 0;
}