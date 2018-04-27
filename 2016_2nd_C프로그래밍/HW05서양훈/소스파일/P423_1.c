#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#define MAX 1000
void write(char * s)
{
	int i = 0;
	fgets(s, MAX, stdin);
	for (i = 0; i < strlen(s); i += 1)
	{
		if ((s[i] >= 'A' && s[i] <= 'Z'))
			s[i] += ('z' - 'Z');
		else if (s[i] >= 'a' && s[i] <= 'z')
			s[i] -= ('z' - 'Z');
	}
	s[strlen(s)-1] = 0;
}
void show_string(char * s)
{
	printf("결과: %s\n", s);
}
int main(void)
{
	char s[100] = { 0, };
	int len = 0;
	
	printf("입력: ");
	write(s);
	show_string(s);
	return 0;
}