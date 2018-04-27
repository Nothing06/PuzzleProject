#include<stdio.h>
#include<stdlib.h>
#include<string.h>
int get_num_sum(char * s)
{
	int i = 0;
	int len = strlen(s);
	int sum = 0;
	for (i = 0; i < len; i += 1)
		if (s[i] >= '0' && s[i] <= '9')
			sum += (s[i] - '0');
	return sum;
}
int main(void)
{
	char str[100] = { 0, };
	printf("문자열 입력: ");
	fgets(str, 100, stdin);
	printf("%d",get_num_sum(str));
	return 0;
}