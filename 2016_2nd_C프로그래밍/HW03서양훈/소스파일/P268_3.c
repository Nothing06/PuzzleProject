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

	printf("���ܾ��Է�: ");
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
	printf("%s �� Ascii�ڵ尡 ���� ū ���� : %c\n", s, maxC);
	printf("%s �� Ascii�ڵ尡 ���� ���� ���� : %c\n", s, minC);
	return 0;
}