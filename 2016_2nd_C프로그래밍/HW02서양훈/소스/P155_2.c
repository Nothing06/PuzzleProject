#include<stdio.h>

int main(void)
{
	int i = 0;
	int cnt = 0;
	int num = 0;

	do {
		printf("�� ���� ���ϴ���?? ");
		scanf("%d", &num);
		getchar();
	} while (num <= 0); // 0 ������ ������ ��� ���Է�.
	do {
		printf("������ �Է��Ͻÿ� : ");
		scanf("%d", &cnt);
		getchar();
	} while (cnt <= 0); // 0 ������ ������ ��� ���Է�.

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