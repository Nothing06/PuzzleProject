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
	printf("함수호출전: %s\n", str1);
	substr(str1, str2); // str1의 문자열에서 str2단어가 포함되 있으면, str1의 해당 자리에 전부 null값('\0')을 넣어   해당 단어를 지워준다.
	printf("함수호출후: %s\n", str1);
	return 0;
}