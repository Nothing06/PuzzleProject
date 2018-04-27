#include<stdio.h>
#include<stdlib.h>
#include<string.h>
void clearBuffer()
{
	int c = 0;
	printf("������ ����: ");
	while ((c) != '\n')
	{
		c = getchar();
		
		if (c == '\n')
			printf("ENTER(%d)", c, c);
		else
			printf("%c(%d), ", c, c);
	}
	
	printf("\nclearBuffer called.\n\n");
}
int main(void)
{
	int len = 0;
	char * str;
	int i = 0;

	printf("�Է��� ���ڿ� ���� �Է�: ");
	scanf("%d", &len);
	getchar();
	str = (char*)malloc(len + 1);
	memset(str, 0, len + 1);
	printf("���ڿ� �Է�: ");
	fgets(str, len+1, stdin);
	if (str[strlen(str) - 1] != '\n')
	{
		clearBuffer();
	}
	else
		str[strlen(str) - 1] = 0;

	for (i = len - 1; i >= 0; i -= 1)
	{
		if (str[i] == ' ')
		{
			str[i] = 0;
			printf("%s", &str[i + 1]);
			if (i > 0)
				printf(" ");
		}
	}
	if(str[0]!=' ')
	printf("%s", &str[0]);
	return 0;
}