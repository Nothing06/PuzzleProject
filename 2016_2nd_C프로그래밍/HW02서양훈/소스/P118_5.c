#include<stdio.h>

int main(void)
{
	char c = 1;

	printf("�ƽ�Ű�ڵ尪 ���\n");
	do
	{
		printf("0~127 ���� ���� �Է�: ");
		scanf("%c", &c);
	} while (c < 0 || c > 127); // 0~127 ������ �ƴ� ��� ���Է�.
	printf("%c�� ASCII CODE��: %d\n", c, c);
	return 0;
}