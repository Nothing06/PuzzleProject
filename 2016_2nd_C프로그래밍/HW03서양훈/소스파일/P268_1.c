#include<stdio.h>
#include<string.h>
#include<ctype.h>
#define ALPHABET_CNT 26
int main(void)
{
	int len = 0;
	char s[100] = { 0, };
	int i = 0;
	int arr[ALPHABET_CNT] = { 0, };

	scanf("%s", s);//�ܾ��̹Ƿ� ���� ���X
	len = strlen(s);

	for (i = 0; i < len; i += 1)
	{
		if (s[i] >= 'A' && s[i] <= 'Z' || (s[i] >= 'a' && s[i] <= 'z'))
		{
			if (s[i] >= 'A' && s[i] <= 'Z')
			{
				s[i] = tolower(s[i]);
			}
			arr[s[i] - 'a'] += 1;
		}
	}
	printf("�ܾ��� ���� : %d\n", len);
	printf("* �ܾ��� ���ĺ��� ����\n");
	for (i = 0; i < ALPHABET_CNT; i += 1)
	{
		if (arr[i] == 0)
			continue;
		printf("%c : %d��\n", i + 97, arr[i]);
	}
	return 0;
}