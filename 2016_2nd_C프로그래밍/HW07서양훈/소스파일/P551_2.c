#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#define EXT 3
void print_numbers(int * p, int len)
{
	int i = 0;
	for (i = 0; i < len; i += 1)
		printf("%d\n", p[i]);
}
int main(void)
{
	int * arr;
	int * tmp;
	int i = 0; // idx���� ������ Ȱ��
	int num = 0;

	arr = (int*)malloc(sizeof(int) * 5);
	memset(arr, 0, sizeof(int) * 5);
	while (1)
	{
		printf("���� �Է�: ");
		scanf("%d", &num);
		getchar();
		if (num == -1)
			break;
		arr[i] = num;
		if (i % 3 == 1 && i >= 4)
		{
			tmp = arr;
			arr = (int*)malloc((i + 1 + EXT) * sizeof(int));
			memset(arr, 0, (i + 1 + EXT) * sizeof(int));
			memcpy(arr, tmp, (i+1) * sizeof(int));
			free(tmp);
			printf("�迭 arr�� Ȯ��Ǿ����ϴ�.\n");
		}
		i += 1;
	}
	print_numbers(arr, i);
	return 0;
}