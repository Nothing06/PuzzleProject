#include<stdio.h>
#define GET_BIG_NUM(a,b) a>b ? a: b
#define GET_SML_NUM(a,b) a>b ? b: a
// ������ ���õ�  �������� ������ ���ٴ� �����Ͽ� ǰ.(�߰�����)
int main(void)
{
	int n1 = 0, n2 = 0;
	int big = 0;
	int small = 0;
	int i = 0;
	int sum = 0;

	printf("�� ���� ���� �Է�: ");
	scanf("%d %d", &n1, &n2);
	big = GET_BIG_NUM(n1, n2);
	small = GET_SML_NUM(n1, n2);

	for (i = small; i <= big; i += 1)
	{
		sum += i;
	}
	printf("sum : %d\n", sum);
	return 0;
}