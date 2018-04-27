#include<stdio.h>
#include<string.h>
void clearBuffer()
{
	while (getchar() != '\n');
}
int main(void)
{
	char s[100] = { 0, };
	int maxC = 0;
	int minC = 'z';
	int i = 0;
	int len = 0;

	printf("영단어입력: ");
	scanf("%s", s);
	clearBuffer();
	len = strlen(s);
	for (i = 0; i < len; i += 1)
	{
		if (maxC < s[i])
			maxC = s[i];
		if (minC > s[i])
			minC = s[i];
	}
	printf("\n");
	printf("%s 중 Ascii코드가 제일 큰 문자 : %c\n", s, maxC);
	printf("%s 중 Ascii코드가 제일 작은 문자 : %c\n", s, minC);
	return 0;
}