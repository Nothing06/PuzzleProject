#include<stdio.h>
#include<stdlib.h>
#include<string.h>

void substr(char * s1, char * s2)
{
	int i = 0;
	char *p;
	int len1 = 0;
	int len2 = 0;

	len1 = strlen(s1);
	len2 = strlen(s2);

	if (p=strstr(s1, s2))
	{
		for (i = 0; i < len2; i += 1)
			*p++ = 0;
	}
	return;
}
int main(void)
{
	char str1[] = "Hello man, have a Good time";
	char str2[] = "time";
	int i = 0;
	
	while (str1[i])
	{
		printf("%c", str1[i]);
		i += 1;
	}
	printf("\n");
	printf("�Լ�ȣ����: %s\n", str1);
	substr(str1, str2); // str1�� ���ڿ����� str2�ܾ ���Ե� ������, str1�� �ش� �ڸ��� ���� null��('\0')�� �־�   �ش� �ܾ �����ش�.
	printf("�Լ�ȣ����: %s\n", str1);
	return 0;
}