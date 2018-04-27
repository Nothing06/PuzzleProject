#include<stdio.h>

int main(void)
{
	int i = 0;
	int cnt = 0;
	int num = 0;

	do {
		printf("몇 단을 원하는지?? ");
		scanf("%d", &num);
		getchar();
	} while (num <= 0); // 0 이하의 숫자일 경우 재입력.
	do {
		printf("개수를 입력하시오 : ");
		scanf("%d", &cnt);
		getchar();
	} while (cnt <= 0); // 0 이하의 숫자일 경우 재입력.

	for (i = 0; i < cnt; i += 1)
	{
		printf("%d ", num * (i + 1));
	}
	printf("\n");
	for (i = 0; i < cnt; i += 1)
	{
		printf(" %d X %d = %d\n", num, i+1, num * (i + 1));
	}	
	return 0;
}