#include<stdio.h>

int main(void)
{
	int c = 1;

	do
	{
		printf("0~127 중의 수를 입력: ");
		scanf("%d", &c);
	} while (c < 0 || c > 127); // 0~127 범위가 아닐 경우 재입력.
	printf("%d의 아스키코드 문자 : %c\n", c, c);
	return 0;
}