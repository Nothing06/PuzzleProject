#include<stdio.h>
#include<string.h>
#include<conio.h>
#define SWAP(x,y,t) (t=x, x=y, y=t)
void reverse_str(char * s)
{
	int i = 0;
	int len = strlen(s);
	int t = 0;
	for (i = 0; i < len/2; i += 1)
	{
		SWAP(s[i], s[len - 1 - i], t);
	}
}
int main(void)
{
	char s[100] = { 0, };

	while (1)
	{
		printf("문자열입력: ");
		fgets(s, 100, stdin);
		s[strlen(s) - 1] = 0;
		if (!strcmp(s, "."))
		{
			printf("Exit Program..\n");
			break;
		}
		printf("Before Reversing: %s\n", s);
		reverse_str(s);
		printf("After Reversing: %s\n", s);
		printf(">> Press Any Key.");
		getch();
		printf("\n\n");
	}
	return 0;
}