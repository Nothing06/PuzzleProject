#include<stdio.h>

int main(void)
{
	int c = 1;

	do
	{
		printf("0~127 ���� ���� �Է�: ");
		scanf("%d", &c);
	} while (c < 0 || c > 127); // 0~127 ������ �ƴ� ��� ���Է�.
	printf("%d�� �ƽ�Ű�ڵ� ���� : %c\n", c, c);
	return 0;
}