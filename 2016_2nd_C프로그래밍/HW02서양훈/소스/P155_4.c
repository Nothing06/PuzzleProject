#include<stdio.h>
#include<stdlib.h>
/*
  2���� ���ڸ� �Է��ϸ�
  �� �� ���ڸ� ������, ���̿� �ִ� 
   n���� ���� ���.
*/
int main(void)
{
	int i = 0;
	int n1 = 0;
	int n2 = 0;
	int bigger_n = 0;
	int smaller_n = 0;
	int k = 0;

	do {
		printf("�� ���� ���?");
		scanf("%d %d", &n1, &n2);
	} while (n1 <= 0 || n2 <= 0);

	bigger_n = (n1 > n2 ? n1 : n2);
	smaller_n = (n1 < n2? n1 : n2);
	
	for (k = smaller_n; k <= bigger_n; k += 1)
	{
		for (i = 9; i > 0; i -= 1)
			printf("%d X %d = %d\n", k, i, k*i);
		printf("\n");
	}
	return 0;
}