#include<stdio.h>

void Hello_world()
{
	printf("Hello world!\n");
}
int main(void)
{
	int i = 0;
	int cnt = 0;

	do {
		printf("���������� �Է��Ͻÿ� : ");
		scanf("%d", &cnt);
		getchar();
	} while (cnt <= 0); // 0 ������ ������ ��� ���Է�.

	for (i = 0; i < cnt; i += 1)
		Hello_world();
	return 0;
}