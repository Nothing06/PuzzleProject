#include<stdio.h>
#include<stdlib.h>
/*
  2개의 숫자를 입력하면
  그 두 숫자를 포함한, 사이에 있는 
   n단을 전부 출력.
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
		printf("몇 단을 출력?");
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